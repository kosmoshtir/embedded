package eu.ilanko.digitalxpplatform.android.api.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.constants.ModelMappingUtils;
import eu.ilanko.digitalxpplatform.android.api.model.PropertyDefinition;
import eu.ilanko.digitalxpplatform.android.api.model.PropertyType;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.definitions.Choice;
import org.apache.chemistry.opencmis.commons.enums.Cardinality;
import org.apache.chemistry.opencmis.commons.enums.Updatability;
@SuppressWarnings("rawtypes")
public class PropertyDefinitionImpl implements PropertyDefinition
{
    private static final long serialVersionUID = 1L;

    private org.apache.chemistry.opencmis.commons.definitions.PropertyDefinition propertyDefinition;

    private boolean isCmis = false;

    // ////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ////////////////////////////////////////////////////////////////////////////////////
    /**
     * Instantiates a new tag impl.
     */
    public PropertyDefinitionImpl()
    {
    }

    /**
     * Instantiates a new tag impl.
     *
     * @param value the value of the tag
     */
    public PropertyDefinitionImpl(
            org.apache.chemistry.opencmis.commons.definitions.PropertyDefinition propertyDefinition)
    {
        this.propertyDefinition = propertyDefinition;
    }

    public PropertyDefinitionImpl(boolean isCmis,
                                  org.apache.chemistry.opencmis.commons.definitions.PropertyDefinition propertyDefinition)
    {
        this.propertyDefinition = propertyDefinition;
        this.isCmis = isCmis;
    }

    // ////////////////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String getName()
    {
        if (propertyDefinition != null) { return (isCmis) ? propertyDefinition.getId() : ModelMappingUtils
                .getIlankoPropertyName(propertyDefinition.getId()); }
        return null;
    }

    @Override
    public String getTitle()
    {
        if (propertyDefinition != null) { return (isCmis) ? propertyDefinition.getDisplayName() : ModelMappingUtils
                .getIlankoPropertyName(propertyDefinition.getDisplayName()); }
        return null;
    }

    @Override
    public String getDescription()
    {
        if (propertyDefinition != null) { return propertyDefinition.getDescription(); }
        return null;
    }

    @Override
    public PropertyType getType()
    {
        if (propertyDefinition != null)
        {
            org.apache.chemistry.opencmis.commons.enums.PropertyType propertyType = propertyDefinition
                    .getPropertyType();
            try
            {
                return PropertyType.fromValue(propertyType.value());
            }
            catch (Exception e)
            {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean isRequired()
    {
        if (propertyDefinition != null)
        {
            // cm:name or cmis:name is always required.
            if (PropertyIds.NAME.equals(propertyDefinition.getId())) { return true; }
            return propertyDefinition.isRequired();
        }
        return false;
    }

    @Override
    public boolean isMultiValued()
    {
        if (propertyDefinition != null && propertyDefinition.getCardinality() != null) { return propertyDefinition
                .getCardinality().equals(Cardinality.MULTI); }
        return false;
    }

    @Override
    public boolean isReadOnly()
    {
        if (propertyDefinition != null && propertyDefinition.getUpdatability() != null) { return propertyDefinition
                .getUpdatability().equals(Updatability.READONLY); }
        return false;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefaultValue()
    {
        if (propertyDefinition != null) { return (T) propertyDefinition.getDefaultValue(); }
        return null;
    }

    @Override
    public List<Map<String, Object>> getAllowableValues()
    {
        List<Map<String, Object>> list = null;
        if (propertyDefinition != null && propertyDefinition.getChoices() != null)
        {
            list = new ArrayList<Map<String,Object>>(propertyDefinition.getChoices().size());
            for (Object choice : propertyDefinition.getChoices())
            {
                Map<String, Object> mapValues = new HashMap<String, Object>();
                mapValues.put(((Choice) choice).getDisplayName(), ((Choice) choice).getValue());
                list.add(mapValues);
            }
            return list;
        }
        return new ArrayList<Map<String, Object>>(0);
    }
}
