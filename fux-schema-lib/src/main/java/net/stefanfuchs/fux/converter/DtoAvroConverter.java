package net.stefanfuchs.fux.converter;

/**
 * @author fuchsste
 */
public interface DtoAvroConverter<DtoType, AvroType extends org.apache.avro.specific.SpecificRecord> {
    DtoType convert(AvroType avroDto);

    AvroType convert(DtoType dto);

}
