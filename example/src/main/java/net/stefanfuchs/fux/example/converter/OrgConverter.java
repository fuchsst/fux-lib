package net.stefanfuchs.fux.example.converter;

import net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO;
import net.stefanfuchs.fux.avro.enums.common.SourceType;
import net.stefanfuchs.fux.avro.enums.common.VerticalType;
import net.stefanfuchs.fux.avro.enums.entity.ad.AdEventType;
import net.stefanfuchs.fux.avro.enums.entity.organisation.OrganisationEventType;
import net.stefanfuchs.fux.converter.DtoAvroConverter;
import net.stefanfuchs.fux.example.dto.OrgEvent;
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
public class OrgConverter implements DtoAvroConverter<OrgEvent, OrganisationEventDTO> {

    private final UUIDService uuidService;

    @Autowired
    public OrgConverter(UUIDService uuidService) {
        this.uuidService = uuidService;
    }

    @Override
    public OrgEvent convert(OrganisationEventDTO avroDto) {
        try {
            OrgEvent orgEvent = new OrgEvent();
            orgEvent.setOrgId(uuidService.getOrgIdForUUid(UUID.fromString(avroDto.getOrgUuid().toString())));
            orgEvent.setEventTime(UuidUtils.getDateFromUuid(UUID.fromString(avroDto.getEventTime().toString())));
            orgEvent.setEventType(AdEventType.valueOf(avroDto.getOrganisationEventType().toString()).ordinal());
            orgEvent.setSourceId(SourceType.valueOf(avroDto.getSourceType().toString()).ordinal());
            orgEvent.setVerticalId(VerticalType.UNDEFINED.ordinal());
            return orgEvent;
        } catch (Exception e) {
            throw new ConversionException("Failed to convert: " + avroDto.toString(), e);
        }
    }

    @Override
    public OrganisationEventDTO convert(OrgEvent dto) {
        try {
            OrganisationEventDTO organisationEventDTO = new OrganisationEventDTO();
            organisationEventDTO.setEventTime(UuidUtils.getTimeUuidFromDate(dto.getEventTime()).toString());
            organisationEventDTO.setOrganisationEventType(OrganisationEventType.values()[dto.getEventType()].name());
            organisationEventDTO.setOrgUuid(uuidService.getUUIDForOrgId(dto.getOrgId()).toString());
            organisationEventDTO.setSourceType(SourceType.values()[dto.getSourceId()].name());
            return organisationEventDTO;
        } catch (Exception e) {
            throw new ConversionException("Failed to convert: " + dto.toString(), e);
        }
    }

}
