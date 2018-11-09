package net.stefanfuchs.fux.schemaregistry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchemaRegistryConfiguration {

    @Bean
    public SchemaRegistryProperties schemaRegistryProperties(@Value("${avro.schemaregistry.autoregister.enabled:true}")
                                                                     boolean autoregisterEnabled,
                                                             @Value("${avro.schemaregistry.url}")
                                                                     String url) {
        return new SchemaRegistryProperties(autoregisterEnabled, url);
    }


    @Bean
    public SchemaRegistryMigrationInitializer schemaRegistryMigrationInitializer(SchemaRegistryProperties schemaRegistryProperties) {
        return new SchemaRegistryMigrationInitializer(schemaRegistryProperties);
    }
}
