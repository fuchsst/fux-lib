package net.stefanfuchs.fux.kafka;

/**
 * List of available/known Kafka Topics
 * E.g. may be used to specify the topic name in the KafkaListener
 */
public interface TopicNames {
    String AD_EVENT = "AdEventsAvro";
    String ORGANISATION_EVENT = "OrganisationEventsAvro";
    String USER_EVENT = "UserEventsAvro";
    String CAR_STATISTICS_AD_DETAIL = "CarStatisticAdDetails";
    String CAR_STATISTICS_MONTHLY_SUMMARY = "CarStatisticMonthlySummary";
}
