package net.stefanfuchs.fux.example.producer;

import net.stefanfuchs.fux.avro.enums.common.SourceType;
import net.stefanfuchs.fux.avro.enums.common.VerticalType;
import net.stefanfuchs.fux.avro.enums.entity.ad.AdEventType;
import net.stefanfuchs.fux.example.dto.AdEvent;

import java.util.Date;
import java.util.Random;

/**
 * @author fuchsste
 */
public class RandomAdEventCreator {
    private static Random RANDOM = new Random();

    public static AdEvent createRandomAdEvent() {
        return new AdEvent(getRandomAdId(),
                getRandomLoginId(),
                new Date(),
                getRandomSource().ordinal(),
                getRandomAdEventType().ordinal(),
                getRandomVertical().ordinal()
        );
    }


    private static long getRandomAdId() {
        final Long[] AD_ID_LIST = {
                219538472L, 220710772L, 221759672L, 219250950L, 223509484L, 219977776L, 221849754L, 219744550L,
                219258354L, 223292300L, 219954330L, 222981332L, 220019732L, 222680236L, 220555288L, 221584444L};
        return AD_ID_LIST[RANDOM.nextInt(AD_ID_LIST.length)];
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

    private static AdEventType getRandomAdEventType() {
        return AdEventType.values()[RANDOM.nextInt(AdEventType.values().length)];
    }

}
