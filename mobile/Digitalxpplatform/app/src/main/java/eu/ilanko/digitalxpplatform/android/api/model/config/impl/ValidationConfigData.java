package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class ValidationConfigData extends ItemConfigData
{
    final String errorId;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    public ValidationConfigData(String identifier, Map<String, Object> json, ConfigurationImpl configuration)
    {
        super(identifier, json, configuration);
        this.errorId = configuration.getString(JSONConverter.getString(json, ConfigConstants.ERROR_ID_VALUE));
    }
}
