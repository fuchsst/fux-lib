package net.stefanfuchs.fux.kafka;


import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaAvroProducerConfig {

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
     * A prefix that will be prepended to every topic name, e.g. environment name (Dev, local-, etc)
     */
    @Value("${kafka.topic.prefix}")
    private String topicPrefix;

    /**
     * A postfix that will be appended to every topic name, e.g. environment name (Dev, local-, etc)
     * Can be used in combination with topicPrefix
     */
    @Value("${kafka.topic.postfix}")
    private String topicPostfix;

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
     * The amount of time to wait before attempting to reconnect to a given host. This avoids repeatedly connecting to a host in a tight loop. This backoff applies to all requests sent by the consumer to the broker.
     */
    @Value("${kafka.reconnect.backoff.ms:500}")
    private Integer reconnectBackoffMs;

    /**
     * The amount of time to wait before attempting to retry a failed request to a given topic partition. This avoids repeatedly sending requests in a tight loop under some failure scenarios.
     */
    @Value("${kafka.retry.backoff.ms:250}")
    private Integer retryBackoffMs;

    /**
     * Setting a value greater than zero will cause the client to resend any record whose send fails with a potentially transient error.
     * Note that this retry is no different than if the client resent the record upon receiving the error.
     * Allowing retries without setting <code>" + MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION + "</code> to 1 will potentially change the
     * ordering of records because if two batches are sent to a single partition, and the first fails and is retried but the second
     * succeeds, then the records in the second batch may appear first.
     */
    @Value("${kafka.producer.retries:3}")
    private Integer retries;

    /**
     * The number of acknowledgments the producer requires the leader to have received before considering a request complete. This controls the
     * durability of records that are sent. The following settings are allowed:
     * <ul>
     * <li><code>acks=0</code> If set to zero then the producer will not wait for any acknowledgment from the
     * server at all. The record will be immediately added to the socket buffer and considered sent. No guarantee can be
     * made that the server has received the record in this case, and the <code>retries</code> configuration will not
     * take effect (as the client won't generally know of any failures). The offset given back for each record will
     * always be set to -1.
     * <li><code>acks=1</code> This will mean the leader will write the record to its local log but will respond
     * without awaiting full acknowledgement from all followers. In this case should the leader fail immediately after
     * acknowledging the record but before the followers have replicated it then the record will be lost.
     * <li><code>acks=all</code> This means the leader will wait for the full set of in-sync replicas to
     * acknowledge the record. This guarantees that the record will not be lost as long as at least one in-sync replica
     * remains alive. This is the strongest available guarantee. This is equivalent to the acks=-1 setting.
     */
    @Value("${kafka.producer.acks:1}")
    private String producerAcks;

    /**
     * The producer will attempt to batch records together into fewer requests whenever multiple records are being sent
     * to the same partition. This helps performance on both the client and the server. This configuration controls the
     * default batch size in bytes.
     * <p>
     * No attempt will be made to batch records larger than this size.
     * <p>
     * Requests sent to brokers will contain multiple batches, one for each partition with data available to be sent.
     * <p>
     * A small batch size will make batching less common and may reduce throughput (a batch size of zero will disable
     * batching entirely). A very large batch size may use memory a bit more wastefully as we will always allocate a
     * buffer of the specified batch size in anticipation of additional records.
     */
    @Value("${kafka.producer.batch.size:8192}")
    private Integer batchSize;

    /**
     * The configuration controls the maximum amount of time the client will wait
     * for the response of a request. If the response is not received before the timeout
     * elapses the client will resend the request if necessary or fail the request if
     * retries are exhausted.
     */
    @Value("${kafka.producer.timeout.ms:30000}")
    private Integer timeoutMs;

    /**
     * The producer groups together any records that arrive in between request transmissions into a single batched request.
     * Normally this occurs only under load when records arrive faster than they can be sent out. However in some circumstances the client may want to
     * reduce the number of requests even under moderate load. This setting accomplishes this by adding a small amount
     * of artificial delay&mdash;that is, rather than immediately sending out a record the producer will wait for up to
     * the given delay to allow other records to be sent so that the sends can be batched together. This can be thought
     * of as analogous to Nagle's algorithm in TCP. This setting gives the upper bound on the delay for batching: once
     * we get <code>" + BATCH_SIZE_CONFIG + "</code> worth of records for a partition it will be sent immediately regardless of this
     * setting, however if we have fewer than this many bytes accumulated for this partition we will 'linger' for the
     * specified time waiting for more records to show up. This setting defaults to 0 (i.e. no delay). Setting <code>" + LINGER_MS_CONFIG + "=5</code>,
     * for example, would have the effect of reducing the number of requests sent but would add up to 5ms of latency to records sent in the absense of load.
     */
    @Value("${kafka.producer.linger.ms:5}")
    private Integer lingerMs;

    public Map<String, Object> getProducerConfig() {
        Map<String, Object> result = new HashMap<>();
        result.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAddress);
        result.put("schema.registry.url", schemaRegistryUrl);
        result.put(ProducerConfig.CLIENT_ID_CONFIG, clientIdConfig);
        result.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        result.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());

        result.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, reconnectBackoffMs);
        result.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackoffMs);
        result.put(ProducerConfig.RETRIES_CONFIG, retries);
        result.put(ProducerConfig.ACKS_CONFIG, producerAcks);
        result.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        result.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        result.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, timeoutMs);
        result.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);

        return result;
    }

    public String getTopicNameWithPreAndPostfix(String topicName) {
        return topicPrefix + topicName + topicPostfix;
    }
}
