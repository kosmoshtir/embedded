package eu.ilanko.digitalxpplatform.android.api.model.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.constants.OnPremiseConstant;
import eu.ilanko.digitalxpplatform.android.api.constants.PublicAPIConstant;
import eu.ilanko.digitalxpplatform.android.api.model.ProcessDefinition;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;

public class ProcessDefinitionImpl implements ProcessDefinition
{
    private static final long serialVersionUID = 1L;

    /** Unique identifier of the process Definition. */
    private String identifier;

    private String name;

    private String key;

    private String version;

    /**
     * Extra data map that contains all information about the specific process definition.
     */
    private Map<String, Serializable> data;

    /**
     * Parse Json Response from Ilanko REST API to create a process Definition
     * Object.
     *
     * @param json : json response that contains data from the repository
     * @return ProcessDefinition Object
     */
    public static ProcessDefinitionImpl parseJson(Map<String, Object> json)
    {
        ProcessDefinitionImpl definition = new ProcessDefinitionImpl();

        // Public Properties
        definition.identifier = JSONConverter.getString(json, OnPremiseConstant.ID_VALUE);
        definition.name = JSONConverter.getString(json, OnPremiseConstant.TITLE_VALUE);
        definition.key = JSONConverter.getString(json, OnPremiseConstant.NAME_VALUE);
        definition.version = JSONConverter.getString(json, OnPremiseConstant.VERSION_VALUE);

        // Extra Properties
        definition.data = new HashMap<String, Serializable>();
        definition.data.put(OnPremiseConstant.DESCRIPTION_VALUE,
                JSONConverter.getString(json, OnPremiseConstant.DESCRIPTION_VALUE));

        return definition;
    }

    public static ProcessDefinition parsePublicAPIJson(Map<String, Object> json)
    {
        ProcessDefinitionImpl definition = new ProcessDefinitionImpl();

        // Public Properties
        definition.identifier = JSONConverter.getString(json, PublicAPIConstant.ID_VALUE);
        definition.name = JSONConverter.getString(json, PublicAPIConstant.NAME_VALUE);
        definition.key = JSONConverter.getString(json, PublicAPIConstant.KEY_VALUE);
        definition.version = JSONConverter.getString(json, PublicAPIConstant.VERSION_VALUE);

        // Extra Properties
        definition.data = new HashMap<String, Serializable>();
        definition.data.put(PublicAPIConstant.CATEGORY_VALUE, JSONConverter.getString(json, PublicAPIConstant.CATEGORY_VALUE));
        definition.data.put(PublicAPIConstant.DEPLOYMENTID_VALUE,
                JSONConverter.getString(json, PublicAPIConstant.DEPLOYMENTID_VALUE));
        definition.data.put(PublicAPIConstant.STARTFORMRESOURCEKEY_VALUE,
                JSONConverter.getString(json, PublicAPIConstant.STARTFORMRESOURCEKEY_VALUE));
        definition.data.put(PublicAPIConstant.GRAPHICNOTATIONDEFINED_VALUE,
                JSONConverter.getString(json, PublicAPIConstant.GRAPHICNOTATIONDEFINED_VALUE));

        return definition;
    }

    /** {@inheritDoc} */
    public String getIdentifier()
    {
        return identifier;
    }

    /** {@inheritDoc} */
    public String getName()
    {
        return name;
    }

    /** {@inheritDoc} */
    public String getVersion()
    {
        return version;
    }

    /** {@inheritDoc} */
    public Map<String, Serializable> getData()
    {
        return data;
    }

    @Override
    public String getKey()
    {
        return key;
    }
}

