package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.FieldGroupConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.FormConfig;
public class FormConfigImpl extends ItemConfigImpl implements FormConfig
{
    private ArrayList<FieldGroupConfig> children;

    protected String evaluatorId;

    protected String layoutId;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    FormConfigImpl()
    {
        super();
    }

    public FormConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                          Map<String, Object> properties, List<FieldGroupConfig> children, String evaluatorId, String layoutId)
    {
        super(identifier, iconIdentifier, label, description, type, evaluatorId, properties);
        this.children = new ArrayList<FieldGroupConfig>(children);
        this.evaluatorId = evaluatorId;
        this.layoutId = layoutId;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getLayout()
    {
        return layoutId;
    }

    @Override
    public List<FieldGroupConfig> getGroups()
    {
        return children;
    }

}

