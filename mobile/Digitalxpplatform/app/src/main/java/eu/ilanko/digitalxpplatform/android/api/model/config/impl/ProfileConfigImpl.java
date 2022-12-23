package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import eu.ilanko.digitalxpplatform.android.api.model.config.ProfileConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class ProfileConfigImpl extends BaseConfigImpl implements ProfileConfig
{
    private boolean isDefault = false;

    private String rootViewId;

    private String rootActionId;

    private String evaluatorId;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ProfileConfigImpl(BaseConfigData data)
    {
        super(data.identifier, data.label, data.description);
    }

    static ProfileConfig parse(String identifier, Map<String, Object> json, ConfigurationImpl configuration)
    {
        BaseConfigData data = new BaseConfigData(identifier, json, configuration);
        ProfileConfigImpl profileConfig = new ProfileConfigImpl(data);

        if (json.containsKey(ConfigConstants.DEFAULT_VALUE))
        {
            profileConfig.isDefault = JSONConverter.getBoolean(json, ConfigConstants.DEFAULT_VALUE);
        }

        profileConfig.evaluatorId = JSONConverter.getString(json, ConfigConstants.EVALUATOR);
        profileConfig.rootViewId = JSONConverter.getString(json, ConfigConstants.ROOTVIEW_ID_VALUE);
        profileConfig.rootActionId = JSONConverter.getString(json, ConfigConstants.ROOTACTION_ID_VALUE);

        return profileConfig;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isDefault()
    {
        return isDefault;
    }

    public String getEvaluator()
    {
        return evaluatorId;
    }

    @Override
    public String getRootViewId()
    {
        return rootViewId;
    }

    @Override
    public String getRootActionId()
    {
        return rootActionId;
    }
}

