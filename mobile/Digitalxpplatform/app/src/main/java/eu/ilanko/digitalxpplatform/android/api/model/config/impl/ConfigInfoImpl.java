package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigInfo;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class ConfigInfoImpl implements ConfigInfo
{
    private String schemaVersion;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ConfigInfoImpl()
    {
    }

    /**
     * Used for default and old version of configuration file from SDK 1.3
     *
     * @param dataDictionaryIdentifier
     * @param configurationIdentifier
     * @param lastModificationTime
     * @return
     */
    public static ConfigInfo from(String dataDictionaryIdentifier, String configurationIdentifier,
                                  long lastModificationTime)
    {
        ConfigInfoImpl config = new ConfigInfoImpl();
        config.schemaVersion = SCHEMA_VERSION_BETA;
        return config;
    }

    /**
     */
    public static ConfigInfo parseJson(Map<String, Object> json)
    {
        if (json == null) { return null; }
        ConfigInfoImpl config = new ConfigInfoImpl();
        config.schemaVersion = JSONConverter.getString(json, ConfigConstants.SCHEMA_VERSION_VALUE);

        return config;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // PUBLIC METHOD
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getSchemaVersion()
    {
        return schemaVersion;
    }
}

