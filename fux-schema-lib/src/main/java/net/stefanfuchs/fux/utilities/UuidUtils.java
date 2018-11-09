package net.stefanfuchs.fux.utilities;


import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public final class UuidUtils {

    public static UUID getTimeUuidFromDate(Date date) {
        return new UUID(UUIDs.makeMSB(UUIDs.fromUnixTimestamp(date.getTime())), UUIDs.CLOCK_SEQ_AND_NODE);
    }

    public static UUID getTimeUuid() {
        return UUIDs.timeBased();
    }

    public static Date getDateFromUuid(UUID timeUuid) {
        return new Date(UUIDs.unixTimestamp(timeUuid));
    }

    public static Instant getInstantFromUuid(UUID timeUuid) {
        return Instant.ofEpochMilli(UUIDs.unixTimestamp(timeUuid));
    }
}
