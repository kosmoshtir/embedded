package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface ConfigInfo
{
    String SCHEMA_VERSION_BETA = "0.0";

    /** Returns the schema version of the configuration file.*/
    String getSchemaVersion();
}
