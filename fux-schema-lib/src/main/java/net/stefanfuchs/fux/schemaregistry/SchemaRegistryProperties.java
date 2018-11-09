package net.stefanfuchs.fux.schemaregistry;

public class SchemaRegistryProperties {

    private final boolean autoregisterEnabled;

    private final String url;

    public SchemaRegistryProperties(boolean autoregisterEnabled, String url) {
        this.autoregisterEnabled = autoregisterEnabled;
        this.url = url;
    }

    public boolean isAutoregisterEnabled() {
        return autoregisterEnabled;
    }

    public String getUrl() {
        return url;
    }
}
