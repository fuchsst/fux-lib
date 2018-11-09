package net.stefanfuchs.fux.schemaregistry;


import net.stefanfuchs.fux.schemaregistry.client.rest.RestService;
import net.stefanfuchs.fux.schemaregistry.client.rest.exceptions.RestClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SchemaRegistryMigrationInitializer implements InitializingBean {
    private static Logger LOGGER = LoggerFactory.getLogger(SchemaRegistryMigrationInitializer.class);

    private final SchemaRegistryProperties schemaRegistryProperties;

    public SchemaRegistryMigrationInitializer(SchemaRegistryProperties schemaRegistryProperties) {
        this.schemaRegistryProperties = schemaRegistryProperties;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (schemaRegistryProperties.isAutoregisterEnabled()) {
            if (StringUtils.isEmpty(schemaRegistryProperties.getUrl())) {
                LOGGER.error("Auto-Register is enabled, but no registry server url provided");
            } else {
                LOGGER.info("Try to register schemas at {}", schemaRegistryProperties.getUrl());
                registerAllAvroSchemasFoundAsResources();
            }
        } else {
            LOGGER.warn("Schema-Registration skipped, since avro.schemaregistry.autoregister.enabled is set to false");
        }
    }

    private Map<String, String> registerAllAvroSchemasFoundAsResources() {
        final String fileExtension = ".avsc";
        final String pathAfter = "/avro/";

        ResourceReader resourceReader = new ResourceReader();
        try {
            Map<String, String> ressourceList = resourceReader.getRessourceNameList(fileExtension);
            LOGGER.info("Found {} schema files", ressourceList.size());
            ressourceList.forEach((String fileName, String schemaJson) -> {
                        final String schemaName = getSchemaNameFromFileName(fileName, pathAfter, fileExtension);
                        sendSchemaToRegistry(schemaRegistryProperties.getUrl(), schemaName, schemaJson);
                    }
            );
            return ressourceList;
        } catch (IOException e) {
            LOGGER.warn("Failed to read files from ressources", e);
        }
        return new HashMap<>();
    }

    private static String getSchemaNameFromFileName(String fileName, String startAfter, String fileExtension) {
        final int startAtPos = fileName.indexOf(startAfter) + startAfter.length();
        final int endAtPos = fileName.indexOf(fileExtension);
        return fileName.substring(startAtPos, endAtPos).replace("/", ".");
    }

    private static void sendSchemaToRegistry(String schemaregistryUrl, String schemaName, String schemaJson) {
        final RestService restService = new RestService(schemaregistryUrl);
        try {
            final int resultCode = restService.registerSchema(schemaJson, schemaName);
            LOGGER.info("Tried to register schema '{}', got id: {}", schemaName, resultCode);
        } catch (IOException e) {
            LOGGER.warn("Unable to register schema '" + schemaName + "' due to IO exception", e);
        } catch (RestClientException e) {
            LOGGER.warn("Unable to register schema '" +
                    schemaName + "': \n\n\n" +
                    schemaJson + "\n\n\n" +
                    "request to registry returned an error", e);
        }
    }

}
