package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigScope;
import eu.ilanko.digitalxpplatform.android.api.model.config.CreationConfig;
public class CreationHelper extends HelperConfig
{
    private CreationConfig creationConfig;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    CreationHelper(ConfigurationImpl context, StringHelper localHelper)
    {
        super(context, localHelper);
    }

    boolean addCreationConfig(Map<String, Object> creationMap)
    {
        if (creationMap == null || creationMap.isEmpty()) { return false; }
        creationConfig = CreationConfigImpl.parse(creationMap, getConfiguration());
        return true;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public CreationConfig getCreationConfig(ConfigScope scope)
    {
        if (creationConfig == null) { return null; }
        return creationConfig;
    }

    public CreationConfig getCreationConfig()
    {
        if (creationConfig == null) { return null; }
        return creationConfig;
    }

    public boolean hasCreationConfig()
    {
        return creationConfig != null;
    }
}

