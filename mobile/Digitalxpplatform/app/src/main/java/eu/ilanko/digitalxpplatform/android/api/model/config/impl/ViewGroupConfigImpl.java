package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ViewConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.ViewGroupConfig;
public class ViewGroupConfigImpl extends ViewConfigImpl implements ViewGroupConfig
{
    private LinkedHashMap<String, ViewConfig> childrenIndex;

    private ArrayList<ViewConfig> children;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ViewGroupConfigImpl(String identifier, String label, String type, ArrayList<ViewConfig> children, String evaluatorId)
    {
        super(identifier, label, type, evaluatorId);
        this.children = (children == null) ? new ArrayList<ViewConfig>(0) : children;
    }

    ViewGroupConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                        Map<String, Object> properties, LinkedHashMap<String, ViewConfig> childrenIndex, ArrayList<String> forms,
                        String evaluatorId)
    {
        super(identifier, iconIdentifier, label, description, type, properties, forms, evaluatorId);
        this.childrenIndex = (childrenIndex == null) ? new LinkedHashMap<String, ViewConfig>(0) : childrenIndex;
        this.children = new ArrayList<>(this.childrenIndex.values());
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public int getChildCount()
    {
        return (children == null) ? 0 : children.size();
    }

    public ViewConfig getChildAt(int index)
    {
        return (children == null) ? null : children.get(index);
    }

    public ViewConfig getChildById(String id)
    {
        return (childrenIndex == null) ? null : childrenIndex.get(id);
    }

    public void setChildren(ArrayList<ViewConfig> children)
    {
        this.children = children;
    }

    @Override
    public List<ViewConfig> getItems()
    {
        return children;
    }
}

