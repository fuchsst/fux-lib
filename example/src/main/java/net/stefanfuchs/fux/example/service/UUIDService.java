package net.stefanfuchs.fux.example.service;

import avro.shaded.com.google.common.collect.BiMap;
import avro.shaded.com.google.common.collect.ImmutableBiMap;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDService {

    static final BiMap<Long, UUID> AD_ID2UUID = ImmutableBiMap.<Long, UUID>builder()
            .put(219538472L, UUID.randomUUID())
            .put(220710772L, UUID.randomUUID())
            .put(221759672L, UUID.randomUUID())
            .put(219250950L, UUID.randomUUID())
            .put(223509484L, UUID.randomUUID())
            .put(219977776L, UUID.randomUUID())
            .put(221849754L, UUID.randomUUID())
            .put(219744550L, UUID.randomUUID())
            .put(219258354L, UUID.randomUUID())
            .put(223292300L, UUID.randomUUID())
            .put(219954330L, UUID.randomUUID())
            .put(222981332L, UUID.randomUUID())
            .put(220019732L, UUID.randomUUID())
            .put(222680236L, UUID.randomUUID())
            .put(220555288L, UUID.randomUUID())
            .put(221584444L, UUID.randomUUID())
            .build();

    static final BiMap<Long, UUID> USER_ID2UUID = ImmutableBiMap.<Long, UUID>builder()
            .put(19001132L, UUID.randomUUID())
            .put(19002366L, UUID.randomUUID())
            .put(19003600L, UUID.randomUUID())
            .put(19004834L, UUID.randomUUID())
            .put(19006068L, UUID.randomUUID())
            .put(19007302L, UUID.randomUUID())
            .put(19008536L, UUID.randomUUID())
            .put(19009770L, UUID.randomUUID())
            .build();

    static final BiMap<Long, UUID> ORG_ID2UUID = ImmutableBiMap.<Long, UUID>builder()
            .put(19529284L, UUID.randomUUID())
            .put(29572810L, UUID.randomUUID())
            .build();


    public Long getAdIdForUUid(UUID uuid) {
        return AD_ID2UUID.inverse().get(uuid);
    }


    public UUID getUUIDForAdId(Long adId) {
        return AD_ID2UUID.get(adId);
    }

    public Long getUserIdForUUid(UUID uuid) {
        return USER_ID2UUID.inverse().get(uuid);
    }

    public UUID getUUIDForUserId(Long userId) {
        return USER_ID2UUID.get(userId);
    }

    public Long getOrgIdForUUid(UUID uuid) {
        return ORG_ID2UUID.inverse().get(uuid);
    }

    public UUID getUUIDForOrgId(Long orgId) {
        return ORG_ID2UUID.get(orgId);
    }
}
