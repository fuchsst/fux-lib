package net.stefanfuchs.fux.example.producer;

import net.stefanfuchs.fux.avro.enums.common.SourceType;
import net.stefanfuchs.fux.avro.enums.common.VerticalType;
import net.stefanfuchs.fux.avro.enums.entity.organisation.OrganisationEventType;
import net.stefanfuchs.fux.example.dto.OrgEvent;

import java.util.Date;
import java.util.Random;

/**
 * @author fuchsste
 */
public class RandomOrgEventCreator {
    private static Random RANDOM = new Random();

    public static OrgEvent createRandomOrgEvent() {
        return new OrgEvent(getRandomOrgId(),
                getRandomLoginId(),
                new Date(),
                getRandomSource().ordinal(),
                getRandomOrgEventType().ordinal(),
                getRandomVertical().ordinal()
        );
    }


    private static long getRandomOrgId() {
        final Long[] ORG_ID_LIST = {19529284L, 29572810L};
        return ORG_ID_LIST[RANDOM.nextInt(ORG_ID_LIST.length)];
    }

    private static long getRandomLoginId() {
        final Long[] LOGIN_ID_LIST = {
                19001132L, 19002366L, 19003600L, 19004834L, 19006068L, 19007302L, 19008536L, 19009770L};
        return LOGIN_ID_LIST[RANDOM.nextInt(LOGIN_ID_LIST.length)];
    }

    private static SourceType getRandomSource() {
        return SourceType.values()[RANDOM.nextInt(SourceType.values().length)];
    }

    private static VerticalType getRandomVertical() {
        return VerticalType.values()[RANDOM.nextInt(VerticalType.values().length)];
    }

    private static OrganisationEventType getRandomOrgEventType() {
        return OrganisationEventType.values()[RANDOM.nextInt(OrganisationEventType.values().length)];
    }

}
