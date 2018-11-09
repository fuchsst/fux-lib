This project provides libraries to serialized data objects as [Avro](https://avro.apache.org/docs/1.8.2/index.html) 
in combination with [Kafka](https://kafka.apache.org/quickstart) 
and the [Confluent Schema Registry](https://docs.confluent.io/current/schema-registry/docs/index.html). 

It acts as a central repository to define the schemas and register them at the Schema Registry Service.

### fux-schema-lib
Contains the schema definitions. 
This module also contains the Java classes for the DTO that is generated from the schema definitions.
When using this library, it will automatically perform the registration of the schemas at a schema registry server.
The URL must be configured using the property `avro.schemaregistry.url`.
If the automatic registration should be switched off, the property `avro.schemaregistry.autoregister.enabled` must be set to false.

### fux-kafka-consumer
Gathers all needed dependencies to consume an Avro DTO from Kafka.
It also sets meaningful defaults (overriding the Kafka defaults, that might change with new versions) for the consumer config that is used by the Spring Kafka Listener.

Available options are:
* kafka.address (mendatory, no default value)
* kafka.client.id - Used in logging
* kafka.consumer.number (default 2)
* kafka.consumer.groupprefix (no default, e.g. might be prefixed if the consumer is run localy)
* kafka.consumer.group (mednatory, no default; the name of the consumer group)
* kafka.reconnect.backoff.ms (default 500)
* kafka.retry.backoff.ms (default 500)
* kafka.auto.commit.interval.ms (default 5000)
* kafka.auto.commit.enabled (default true)
* kafka.connections.max.idle.ms (default 540000=9min)

### fux-kafka-producer
Gathers all needed dependencies to produce an Avro DTO to Kafka.
It also sets meaningful defaults (overriding the Kafka defaults, that might change with new versions) for the producer config that is used by the KafkaTemplate when calling 
`net.stefanfuchs.fux.kafka.KafkaProducerConfig.getKafkaTemplate`.

Available options are:
* kafka.address (mendatory, no default value) - host/port (list separated by comma) to Kafka Broker
* schema.registry.url (mendatory, no default value) - host/port to Avro Schema Registry
* kafka.client.id - Used in logging
* kafka.reconnect.backoff.ms (default 500)
* kafka.retry.backoff.ms (default 250)
* kafka.producer.retries (default 3)
* kafka.producer.acks (default 1; possible are 0,1,all)
* kafka.producer.batch.size (default 8192)
* kafka.producer.timeout.ms (default 30000)

### Using the library
For a simple example of the usage, check out the example module. 
It both produces, consumes and implements the converter interface including the converter registry for the producer (see description below).   

#### Adding a new Schema
A documentation of the Avro Schema definition format can be found at [Avro Schema 1.8.2 Spec](https://avro.apache.org/docs/1.8.2/spec.html).
All schemas are stored in the `fux-schema-lib` module under `/src/main/resources/avro`.
The library will automatically scan the directory with its subdirectories and register the schemas on each startup of the application.

The directory structure below should follow the package structure of the generated DTOs.
E.g. the schema for the AdEventDTO is stored in a file named `/src/main/resources/avro/dto.ad.AdEvent.DTO.avsc`.
The corresponding namespace (package name) of the DTO would be `net.stefanfuchs.fux.avro.dto.ad`.

To tell the Avro code generator to compile the Java DTO for that schema, 
it is mendatory to add the file to the Maven Plugin config of the [avro-maven-plugin](https://avro.apache.org/docs/1.8.2/gettingstartedjava.html).
Open the `pom.xml` of the `fux-schema-lib` module and look for 
```
<build>
    <plugins>
        ...
        <plugin>
            <groupId>org.apache.avro</groupId>
            <artifactId>avro-maven-plugin</artifactId>
            <version>${avro.version}</version>
            <executions>
                <execution>
                    ...
                    <configuration>
                        <imports>
----->                      <import>${avro.schema.dir}dto/example/SchemaDef.avsc</import>
                            ...
                        </imports>
                        <sourceDirectory>${avro.schema.dir}</sourceDirectory>
                        <outputDirectory>${generatedsources.dir}</outputDirectory>
                    </configuration>
                </execution>
            </executions>
        </plugin> 
```
Add the new schema as an import, like the line marked with an arrow in the snipped above.

It is also advised to link the Schema to the Kafka Topic that is used. 
To do this, add first the Topic name to the list of constants: `TopicNames`.
Afterwards link the DTO to the Topic, by adding a new enum entry to: `TopicDtoRegistry`.

#### Guideline for Schema definitions
* use the doc field
* mind that the schema must be both back- and forward compatible (use null &amp; default values)
* enums must be serialized as strings (a schema for the corresponding enum of a field might be defined too, but is only for documentation purposes)

#### Using a Schema as a consumer
Add the module `fux-kafka-consumer` to your project.
The application properties must at least configure the following:
* kafka.address: url (list) to the Kafka Cluster
* avro.schemaregistry.url: url to the Avro Schema Registry
* kafka.consumer.groupprefix: a prefix to distinguish different variants of you application (e.g. executed on the local PC vs. DEV environment)
* kafka.consumer.group: a unique identifier of the application that all instances belong to

Annotate a Spring Configuration with `@EnableKafka`.
Add a method to a @Service annotated class like in the following example:
```
@KafkaListener(containerFactory = KafkaAvroConsumerConfig.listenerFactoryName, topics = TopicNames.AD_EVENT)
public void consumeAdEvent(ConsumerRecord<String, AdEventDTO> consumerRecord) {
    LOGGER.info(adConverter.convert(consumerRecord.value()).toString());
}
```
It is important to explicitly define the `containerFactory` for the listener as done in the example. 

It is advised to convert the Avro DTO to an internal representation used within your application.
For the conversion, the interface `DtoAvroConverter` should be implemented.

#### Using a Schema as a producer
Add the module `fux-kafke-producer` to your project.
The application must at least configure the following:
* kafka.address: url (list) to the Kafka Cluster
* avro.schemaregistry.url: url to the Avro Schema Registry

Autowire `KafkaAvroProducer`. An Avro DTO can be send using `KafkaAvroProducer.send`.
There are three overloads available:
* send(String key, SpecificRecord data): `data` is a Avro DTO
* send(String key, Object dto): `dto` is an application specific DTO with an entry in the converter registry (see below)
* send(String key, Object dto, DtoAvroConverter converter): `dto` is an application specific DTO and `converter` the corresponding DTO converter between internal DTO and Avro DTO

All of the above expect to have an entry in `ConverterRegistry`.
`key` is the key used by Kafka to determine the partition.

The library provides a converter registry. 
Register a converter (that implements `DtoAvroConverter`) using `KafkaAvroProducer.registerConverter` before sending the first event to Kafka.
With this, it is possible to use the first `send` mentioned above, sending application specific DTO in a convinient way.