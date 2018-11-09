package net.stefanfuchs.fux.kafka;

import net.stefanfuchs.fux.converter.ConverterRegistry;
import net.stefanfuchs.fux.converter.DtoAvroConverter;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author fuchsste
 */
@Service
public class KafkaAvroProducer {

    private final Map<Class<? extends SpecificRecord>, String> TOPIC_LOOKUP = TopicDtoRegistry.getTopicsByAvroDtoClassMap();

    private KafkaTemplate<String, SpecificRecord> kafkaTemplate;
    private final KafkaAvroProducerConfig kafkaAvroProducerConfig;
    private final ConverterRegistry converterRegistry;

    @Autowired
    public KafkaAvroProducer(KafkaAvroProducerConfig kafkaAvroProducerConfig, ConverterRegistry converterRegistry) {
        this.kafkaAvroProducerConfig = kafkaAvroProducerConfig;
        this.converterRegistry = converterRegistry;
    }

    @PostConstruct
    private void initKafkaTemplate() {
        ProducerFactory<String, SpecificRecord> producerFactory =
                new DefaultKafkaProducerFactory<>(kafkaAvroProducerConfig.getProducerConfig());
        kafkaTemplate = new KafkaTemplate<>(producerFactory);
    }

    public ListenableFuture<SendResult<String, SpecificRecord>> send(String key, SpecificRecord data) {
        String topic = kafkaAvroProducerConfig.getTopicNameWithPreAndPostfix(TOPIC_LOOKUP.get(data.getClass()));
        return kafkaTemplate.send(topic, key, data);
    }

    public ListenableFuture<SendResult<String, SpecificRecord>> send(String key, Object dto) throws ClassNotFoundException {
        SpecificRecord data = converterRegistry.convert(dto);
        return this.send(key, data);
    }

    public ListenableFuture<SendResult<String, SpecificRecord>> send(String key, Object dto, DtoAvroConverter converter) {
        SpecificRecord data = converter.convert(dto);
        return this.send(key, data);
    }

    public void registerConverter(Class dtoClass, DtoAvroConverter dtoAvroConverter) {
        converterRegistry.register(dtoClass, dtoAvroConverter);
    }


    public void flush() {
        kafkaTemplate.flush();
    }
}
