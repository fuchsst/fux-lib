package net.stefanfuchs.fux.example.converter;

import net.stefanfuchs.fux.avro.dto.ad.AdEventDTO;
import net.stefanfuchs.fux.avro.enums.common.SourceType;
import net.stefanfuchs.fux.avro.enums.common.VerticalType;
import net.stefanfuchs.fux.avro.enums.entity.ad.AdEventType;
import net.stefanfuchs.fux.converter.DtoAvroConverter;
import net.stefanfuchs.fux.example.dto.AdEvent;
import net.stefanfuchs.fux.example.service.UUIDService;
import net.stefanfuchs.fux.utilities.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.converter.ConversionException;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author fuchsste
 */
@Service
public class AdConverter implements DtoAvroConverter<AdEvent, AdEventDTO> {

    private final UUIDService uuidService;

    @Autowired
    public AdConverter(UUIDService uuidService) {
        this.uuidService = uuidService;
    }

    @Override
    public AdEvent convert(AdEventDTO adEventDTO) {
        try {
            AdEvent adEvent = new AdEvent();
            adEvent.setAdId(uuidService.getAdIdForUUid(UUID.fromString(adEventDTO.getAdUuid().toString())));
            adEvent.setLoginId(uuidService.getUserIdForUUid(UUID.fromString(adEventDTO.getUserUuid().toString())));
            adEvent.setEventTime(UuidUtils.getDateFromUuid(UUID.fromString(adEventDTO.getEventTime().toString())));
            adEvent.setEventType(AdEventType.valueOf(adEventDTO.getAdEventType().toString()).ordinal());
            adEvent.setSourceId(SourceType.valueOf(adEventDTO.getSource().toString()).ordinal());
            adEvent.setVerticalId(VerticalType.valueOf(adEventDTO.getVertical().toString()).ordinal());
            return adEvent;
        } catch (Exception e) {
            throw new ConversionException("Failed to convert: " + adEventDTO.toString(), e);
        }
    }

    @Override
    public AdEventDTO convert(AdEvent adEvent) {
        try {
            String eventTime = UuidUtils.getTimeUuidFromDate(adEvent.getEventTime()).toString();
            String userUuid = uuidService.getUUIDForUserId(adEvent.getLoginId()).toString();
            String adUuid = uuidService.getUUIDForAdId(adEvent.getAdId()).toString();
            String source = SourceType.values()[adEvent.getSourceId()].name();
            String vertical = VerticalType.values()[adEvent.getVerticalId()].name();
            String adEventType = AdEventType.values()[adEvent.getEventType()].name();
            return new AdEventDTO(eventTime, userUuid, adUuid, source, 0, vertical, adEventType, null);
        } catch (Exception e) {
            throw new ConversionException("Failed to convert: " + adEvent.toString(), e);
        }
    }

}
