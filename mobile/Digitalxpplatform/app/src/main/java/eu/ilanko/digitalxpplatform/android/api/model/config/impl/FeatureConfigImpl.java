package eu.ilanko.digitalxpplatform.android.api.model.config.impl;

import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import eu.ilanko.digitalxpplatform.android.api.model.config.FeatureConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class FeatureConfigImpl extends ItemConfigImpl implements FeatureConfig
{
    private boolean isEnable = false;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    FeatureConfigImpl()
    {
        super();
    }

    FeatureConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                      Map<String, Object> properties)
    {
        super(identifier, iconIdentifier, label, description, type, null, properties);
    }

    static FeatureConfigImpl parse(Map<String, Object> json, ConfigurationImpl configuration)
    {
        ItemConfigData data = new ItemConfigData(JSONConverter.getString(json, ConfigConstants.ID_VALUE), json,
                configuration);
        FeatureConfigImpl featureConfig = new FeatureConfigImpl(data.identifier, data.iconIdentifier, data.label,
                data.description, data.type, data.properties);
        if (json.containsKey(ConfigConstants.ENABLE_VALUE))
        {
            featureConfig.isEnable = JSONConverter.getBoolean(json, ConfigConstants.ENABLE_VALUE);
        }
        return featureConfig;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isEnable()
    {
        return isEnable;
    }
}

