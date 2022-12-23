package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ActionConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.ActionGroupConfig;
public class ActionGroupConfigImpl extends ActionConfigImpl implements ActionGroupConfig
{
    private LinkedHashMap<String, ActionConfig> childrenIndex;

    private ArrayList<ActionConfig> children;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ActionGroupConfigImpl(String identifier, String label, String type, ArrayList<ActionConfig> children,
                          String evaluatorId)
    {
        super(identifier, label, type, evaluatorId);
        this.children = (children == null) ? new ArrayList<ActionConfig>(0) : children;
    }

    ActionGroupConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                          Map<String, Object> properties, LinkedHashMap<String, ActionConfig> childrenIndex, String evaluatorId)
    {
        super(identifier, iconIdentifier, label, description, type, properties, true, evaluatorId);
        this.childrenIndex = (childrenIndex == null) ? new LinkedHashMap<String, ActionConfig>(0) : childrenIndex;
        this.children = new ArrayList<>(this.childrenIndex.values());
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public int getChildCount()
    {
        return (children == null) ? 0 : children.size();
    }

    public ActionConfig getChildAt(int index)
    {
        return (children == null) ? null : children.get(index);
    }

    public ActionConfig getChildById(String id)
    {
        return (childrenIndex == null) ? null : childrenIndex.get(id);
    }

    public void setChildren(ArrayList<ActionConfig> children)
    {
        this.children = children;
    }

    @Override
    public List<ActionConfig> getItems()
    {
        return children;
    }
}
