package net.stefanfuchs.fux.example;

import net.stefanfuchs.fux.example.consumer.ExampleListener;
import net.stefanfuchs.fux.example.producer.ExampleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableKafka
@EnableScheduling
public class ExampleConfig {

    private final ExampleProducer exampleProducer;
    private final ExampleListener exampleListener;

    @Autowired
    public ExampleConfig(ExampleProducer exampleProducer, ExampleListener exampleListener) {
        this.exampleProducer = exampleProducer;
        this.exampleListener = exampleListener;
    }
}
