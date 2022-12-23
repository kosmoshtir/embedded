package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class FormConfigData extends ItemConfigData
{
    final String layoutId;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    public FormConfigData(String identifier, Map<String, Object> json, ConfigurationImpl configuration)
    {
        super(identifier, json, configuration);
        this.layoutId = JSONConverter.getString(json, ConfigConstants.LAYOUT_VALUE);
    }
}
