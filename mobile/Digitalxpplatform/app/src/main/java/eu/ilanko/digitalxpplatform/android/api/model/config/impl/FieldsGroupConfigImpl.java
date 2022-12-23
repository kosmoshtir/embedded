package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.FieldConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.FieldGroupConfig;
public class FieldsGroupConfigImpl extends FieldConfigImpl implements FieldGroupConfig
{
    private LinkedHashMap<String, FieldConfig> childrenIndex;

    private ArrayList<FieldConfig> children;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    FieldsGroupConfigImpl(String identifier, String label, String type, ArrayList<FieldConfig> children,
                          String evaluatorId)
    {
        super(identifier, label, type, evaluatorId);
        this.children = (children == null) ? new ArrayList<FieldConfig>(0) : children;
    }

    FieldsGroupConfigImpl(String identifier,  String iconIdentifier, String label, String description, String type, Map<String, Object> properties,
                          LinkedHashMap<String, FieldConfig> childrenIndex, ArrayList<String> forms, String evaluatorId, String modelIdentifier)
    {
        super(identifier, iconIdentifier, label, description, type, properties, forms, evaluatorId, modelIdentifier, null);
        this.childrenIndex = (childrenIndex == null) ? new LinkedHashMap<String, FieldConfig>(0) : childrenIndex;
        this.children = new ArrayList<FieldConfig>(this.childrenIndex.values());
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public int getChildCount()
    {
        return (children == null) ? 0 : children.size();
    }

    public FieldConfig getChildAt(int index)
    {
        return (children == null) ? null : children.get(index);
    }

    public FieldConfig getChildById(String id)
    {
        return (childrenIndex == null) ? null : childrenIndex.get(id);
    }

    public void setChildren(ArrayList<FieldConfig> children)
    {
        this.children = children;
    }

    @Override
    public List<FieldConfig> getItems()
    {
        return children;
    }


}

