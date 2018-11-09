package net.stefanfuchs.fux.example.producer;

import net.stefanfuchs.fux.example.converter.AdConverter;
import net.stefanfuchs.fux.example.converter.OrgConverter;
import net.stefanfuchs.fux.example.dto.AdEvent;
import net.stefanfuchs.fux.example.dto.OrgEvent;
import net.stefanfuchs.fux.kafka.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * @author fuchsste
 */
@Component
public class ExampleProducer {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExampleProducer.class);
    private static final Random RANDOM = new Random();

    @Value("${kafka.address}")
    private String kafkaAddress;

    private final KafkaAvroProducer kafkaAvroProducer;
    private final AdConverter adConverter;
    private final OrgConverter orgConverter;

    @Autowired
    public ExampleProducer(KafkaAvroProducer kafkaAvroProducer,
                           AdConverter adConverter,
                           OrgConverter orgConverter) {
        this.kafkaAvroProducer = kafkaAvroProducer;
        this.adConverter = adConverter;
        this.orgConverter = orgConverter;
    }

    @PostConstruct
    public void sendRandomEvents() throws InterruptedException {
        LOGGER.info("kafkaAddress: " + kafkaAddress);
        kafkaAvroProducer.registerConverter(AdEvent.class, adConverter);
        kafkaAvroProducer.registerConverter(OrgEvent.class, orgConverter);
    }

    @Scheduled(fixedDelay = 2500)
    public void produceRandomEvents() throws InterruptedException {
        sendRandomAdEvent();
        sendRandomOrgEvent();
    }

    private void sendRandomAdEvent() {
        AdEvent adEvent = RandomAdEventCreator.createRandomAdEvent();
        try {
            kafkaAvroProducer.send(String.valueOf(adEvent.getAdId()), adEvent);
        } catch (Exception e) {
            LOGGER.error("Failed to convert: " + adEvent.toString(), e);
        }
    }

    private void sendRandomOrgEvent() {
        if (RANDOM.nextInt() % 4 == 0) {
            OrgEvent orgEvent = RandomOrgEventCreator.createRandomOrgEvent();
            try {
                kafkaAvroProducer.send(String.valueOf(orgEvent.getOrgId()), orgEvent);
            } catch (Exception e) {
                LOGGER.error("Failed to convert: " + orgEvent.toString(), e);
            }
        }
    }
}
