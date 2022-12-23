package eu.ilanko.digitalxpplatform.android.api.model.config.impl;

import java.io.Serializable;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ActionConfig;
public class ActionConfigImpl extends ItemConfigImpl implements ActionConfig, Serializable
{
    protected String evaluatorId;

    private boolean isEnable = true;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    public ActionConfigImpl(String identifier, String label, String type, Map<String, Object> properties,
                            boolean enable)
    {
        super(identifier, null, label, null, type, null, properties);
        isEnable = enable;
    }

    public ActionConfigImpl(String identifier, String iconIdentifier, String label, String type,
                            Map<String, Object> properties, boolean enable)
    {
        super(identifier, null, label, null, type, null, properties);
        isEnable = enable;
    }

    public ActionConfigImpl(String identifier, String label, String type, String evaluatorId)
    {
        super(identifier, null, label, null, type, evaluatorId, null);
        this.evaluatorId = evaluatorId;
    }

    public ActionConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                            Map<String, Object> properties, boolean enable, String evaluatorId)
    {
        super(identifier, iconIdentifier, label, description, type, evaluatorId, properties);
        this.evaluatorId = evaluatorId;
        isEnable = enable;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public String getEvaluator()
    {
        return evaluatorId;
    }

    @Override
    public boolean isEnable()
    {
        return isEnable;
    }
}

