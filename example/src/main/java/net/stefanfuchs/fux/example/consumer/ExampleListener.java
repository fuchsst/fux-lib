package net.stefanfuchs.fux.example.consumer;

import net.stefanfuchs.fux.avro.dto.ad.AdEventDTO;
import net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO;
import net.stefanfuchs.fux.example.converter.AdConverter;
import net.stefanfuchs.fux.example.converter.OrgConverter;
import net.stefanfuchs.fux.kafka.KafkaAvroConsumerConfig;
import net.stefanfuchs.fux.kafka.TopicNames;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author fuchsste
 */
@Component
public class ExampleListener {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExampleListener.class);

    private final AdConverter adConverter;
    private final OrgConverter orgConverter;

    @Autowired
    public ExampleListener(AdConverter adConverter,
                           OrgConverter orgConverter) {
        this.adConverter = adConverter;
        this.orgConverter = orgConverter;
    }

    @KafkaListener(containerFactory = KafkaAvroConsumerConfig.LISTENER_FACTORY_NAME, topics = TopicNames.AD_EVENT)
    public void consumeAdEvent(ConsumerRecord<String, AdEventDTO> consumerRecord) {
        LOGGER.info(adConverter.convert(consumerRecord.value()).toString());
    }

    @KafkaListener(containerFactory = KafkaAvroConsumerConfig.LISTENER_FACTORY_NAME, topics = TopicNames.ORGANISATION_EVENT)
    public void consumeOrgEvent(ConsumerRecord<String, OrganisationEventDTO> consumerRecord) {
        LOGGER.info(orgConverter.convert(consumerRecord.value()).toString());
    }
}
