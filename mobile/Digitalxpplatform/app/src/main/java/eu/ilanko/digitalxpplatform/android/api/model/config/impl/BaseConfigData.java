package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;

import android.text.TextUtils;
public class BaseConfigData
{
    final String identifier;

    final String label;

    final String description;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    BaseConfigData(String identifier, Map<String, Object> json, ConfigurationImpl configuration)
    {
        if (!TextUtils.isEmpty(identifier))
        {
            this.identifier = identifier;
        }
        else
        {
            this.identifier = JSONConverter.getString(json, ConfigConstants.ID_VALUE);
        }
        this.description = configuration.getString(JSONConverter.getString(json, ConfigConstants.DESCRIPTION_ID_VALUE));
        this.label = configuration.getString(JSONConverter.getString(json, ConfigConstants.LABEL_ID_VALUE));
    }
}

