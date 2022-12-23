package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ViewConfig;
public class ViewConfigImpl extends ItemConfigImpl implements ViewConfig, Serializable
{
    protected String evaluatorId;

    protected ArrayList<String> forms;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    public ViewConfigImpl(String identifier, String label, String type, Map<String, Object> properties)
    {
        super(identifier, null, label, null, type, null, properties);
    }

    public ViewConfigImpl(String identifier, String iconIdentifier, String label, String type,
                          Map<String, Object> properties)
    {
        super(identifier, null, label, null, type, null, properties);
    }

    public ViewConfigImpl(String identifier, String label, String type, String evaluatorId)
    {
        super(identifier, null, label, null, type, evaluatorId, null);
        this.evaluatorId = evaluatorId;
    }

    public ViewConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                          Map<String, Object> properties,
                          ArrayList<String> forms, String evaluatorId)
    {
        super(identifier, iconIdentifier, label, description, type, evaluatorId, properties);
        this.evaluatorId = evaluatorId;
        this.forms = (forms == null) ? new ArrayList<String>(0) : forms;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public String getEvaluator()
    {
        return evaluatorId;
    }

    @Override
    public List<String> getForms()
    {
        return forms;
    }
}

