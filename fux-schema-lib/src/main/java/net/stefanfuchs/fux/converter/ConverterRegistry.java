package net.stefanfuchs.fux.converter;

import avro.shaded.com.google.common.base.Preconditions;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * The registry can be used to look up the proper converter for an Avro DTO
 */
@Service
public class ConverterRegistry {

    private final Map<Class, DtoAvroConverter> registry = new HashMap<>();

    /**
     * Add a converter to the registry for a specific DTO class
     *
     * @param dtoClass         class of the DTO to convert from
     * @param dtoAvroConverter the converter that converts that DTO between Avro and application specific DTO
     */
    public void register(Class dtoClass, DtoAvroConverter dtoAvroConverter) {
        registry.put(dtoClass, dtoAvroConverter);
    }

    /**
     * Converts a DTO to/from Avro
     *
     * @param dto The DTO to convert
     * @return The converted DTO
     * @throws ClassNotFoundException if no converter was registered for the class of that DTO
     */
    public SpecificRecord convert(Object dto) throws ClassNotFoundException {
        return getConverter(dto.getClass()).convert(dto);
    }

    /**
     * Lookup a converter by the DTO class
     *
     * @param dtoClass The class of the DTO
     * @return The registered converter
     * @throws ClassNotFoundException if the DTO class was not found in the registry
     */
    public DtoAvroConverter getConverter(Class dtoClass) throws ClassNotFoundException {
        Preconditions.checkNotNull(dtoClass, "No class was provided when looking up the DtoAvroConverter");

        try {
            return registry.get(dtoClass);
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("No converter registered for " + dtoClass.getName());
        }
    }
}
