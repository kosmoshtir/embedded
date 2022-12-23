package eu.ilanko.digitalxpplatform.android.api.model.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.ModelDefinition;
import eu.ilanko.digitalxpplatform.android.api.model.TaskTypeDefinition;
import org.apache.chemistry.opencmis.client.api.ObjectType;
public class TaskTypeDefinitionImpl extends NodeTypeDefinitionImpl implements TaskTypeDefinition
{
    private static final long serialVersionUID = 1L;

    TaskTypeDefinitionImpl()
    {
        super();
    }

    public TaskTypeDefinitionImpl(ObjectType typeDefinition)
    {
        super(typeDefinition);
    }

    public TaskTypeDefinitionImpl(ObjectType typeDefinition, Map<String, ModelDefinition> aspectModels)
    {
        super(typeDefinition, aspectModels);
    }

}

