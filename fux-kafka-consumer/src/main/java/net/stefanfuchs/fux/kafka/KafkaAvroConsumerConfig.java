package net.stefanfuchs.fux.kafka;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaAvroConsumerConfig {

    /**
     * A list of host/port pairs to use for establishing the initial connection to the Kafka cluster. The client will make use of all servers irrespective of which servers are specified here for bootstrapping&mdash;this list only impacts the initial hosts used to discover the full set of servers. This list should be in the form
     * <code>host1:port1,host2:port2,...</code>. Since these servers are just used for the initial connection to
     * discover the full cluster membership (which may change dynamically), this list need not contain the full set of
     * servers (you may want more than one, though, in case a server is down).
     */
    @Value("${kafka.address}")
    @NotNull
    private String brokerAddress;

    /**
     * Url to the Avro Schema Registry
     */
    @Value("${avro.schemaregistry.url}")
    @NotNull
    private String schemaRegistryUrl;

    /**
     * An id string to pass to the server when making requests. The purpose of this is to be able to track the source of requests beyond just ip/port by allowing a logical application name to be included in server-side request logging.
     */
    @Value("${kafka.client.id}")
    private String clientIdConfig;

    /**
     * Number of consumer threads per instance
     */
    @Value("${kafka.consumer.number:2}")
    @NotNull
    private Integer numberOfConsumers;

    /**
     * A prefix used for the consumer group, e.g. when run localy
     */
    @Value("${kafka.consumer.groupprefix}")
    @NotNull
    private String consumerGroupPrefix;

    /**
     * A unique string that identifies the consumer group this consumer belongs to. This property is required if the consumer uses either the group management functionality by using <code>subscribe(topic)</code> or the Kafka-based offset management strategy.
     */
    @Value("${kafka.consumer.group}")
    @NotNull
    private String consumerGroup;

    /**
     * The amount of time to wait before attempting to reconnect to a given host. This avoids repeatedly connecting to a host in a tight loop. This backoff applies to all requests sent by the consumer to the broker.
     */
    @Value("${kafka.reconnect.backoff.ms:500}")
    @Min(1)
    private Integer reconnectBackoffMs;

    /**
     * The amount of time to wait before attempting to retry a failed request to a given topic partition. This avoids repeatedly sending requests in a tight loop under some failure scenarios.
     */
    @Value("${kafka.retry.backoff.ms:500}")
    @Min(1)
    private Integer retryBackoffMs;

    /**
     * The frequency in milliseconds that the consumer offsets are auto-committed to Kafka if <code>enable.auto.commit</code> is set to <code>true</code>.
     */
    @Value("${kafka.auto.commit.interval.ms:5000}")
    @Min(1)
    private Integer autoCommitInterval;

    /**
     * If true the consumer's offset will be periodically committed in the background.
     */
    @Value("${kafka.auto.commit.enabled:true}")
    @NotNull
    private Boolean autoCommitEnabled;

    /**
     * Close idle connections after the number of milliseconds specified by this config.
     */
    @Value("${kafka.connections.max.idle.ms:540000}")
    @Min(1)
    private Integer connectionsMaxIdleMs;

    /**
     * To prevent interferences with other Kafka Consumers, the name of the Avro Consumer factory
     * is not the standard one and must be references in the annotation (containerFactory parameter) of the listener.
     * Use this constant to reference the container factory
     */
    public final static String LISTENER_FACTORY_NAME = "kafkaAvroListenerContainerFactory";

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, SpecificRecord> kafkaAvroListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SpecificRecord> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConcurrency(numberOfConsumers);
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    private ConsumerFactory<String, SpecificRecord> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(getConsumerConfig());
    }

    public Map<String, Object> getConsumerConfig() {
        Map<String, Object> result = new HashMap<>();
        result.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAddress);
        result.put("schema.registry.url", schemaRegistryUrl);
        result.put(ConsumerConfig.CLIENT_ID_CONFIG, clientIdConfig);
        result.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupPrefix + consumerGroup);
        result.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        result.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        result.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");

        result.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, reconnectBackoffMs);
        result.put(ConsumerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackoffMs);
        result.put(ConsumerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, connectionsMaxIdleMs);
        result.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommitEnabled);
        result.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);

        return result;
    }
}
