package net.stefanfuchs.fux.kafka;


import net.stefanfuchs.fux.avro.dto.ad.AdEventDTO;
import net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO;
import net.stefanfuchs.fux.avro.dto.user.UserEventDTO;
import org.apache.avro.specific.SpecificRecord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Links an Avro DTO to each of the Kafka Topics (each Topic has exactly one DTO attached)
 */
public enum TopicDtoRegistry {

    AD_EVENT(TopicNames.AD_EVENT, AdEventDTO.class),
    ORGANISATION_EVENT(TopicNames.ORGANISATION_EVENT, OrganisationEventDTO.class),
    USER_EVENT(TopicNames.USER_EVENT, UserEventDTO.class);

    private final String topic;
    private final Class<? extends SpecificRecord> avroDtoClass;

    TopicDtoRegistry(String topic, Class<? extends SpecificRecord> avroDtoClass) {
        this.topic = topic;
        this.avroDtoClass = avroDtoClass;
    }

    public String getTopic() {
        return topic;
    }

    public Class<? extends SpecificRecord> getAvroDtoClass() {
        return avroDtoClass;
    }

    static public Map<Class<? extends SpecificRecord>, String> getTopicsByAvroDtoClassMap() {
        return Arrays
                .stream(TopicDtoRegistry.values())
                .collect(Collectors.toMap(TopicDtoRegistry::getAvroDtoClass, TopicDtoRegistry::getTopic, (a, b) -> b, HashMap::new));
    }
}
