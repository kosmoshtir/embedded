package eu.ilanko.digitalxpplatform.android.api.model.impl;
import java.util.GregorianCalendar;

import eu.ilanko.digitalxpplatform.android.api.model.Property;
import eu.ilanko.digitalxpplatform.android.api.model.PropertyType;
@SuppressWarnings("rawtypes")
public class PropertyImpl implements Property
{

    private static final long serialVersionUID = 1L;

    /** CMIS Property Object associated. */
    private org.apache.chemistry.opencmis.client.api.Property prop;

    /** Simple representation of property value. */
    private Object value;

    private PropertyType type;

    private Boolean isMultiValued;

    private String displayName;

    /**
     * Use by default for creating property object that wraps an OpenCMIS
     * Property.
     *
     * @param value
     */
    public PropertyImpl(org.apache.chemistry.opencmis.client.api.Property prop)
    {
        this.prop = prop;
    }

    /**
     * Constructor based that define a property exclusively by its standard
     * value. </br> Use this constructor for creating simple property object.
     *
     * @param value : default value for the specific property
     */
    public PropertyImpl(Object value)
    {
        this.value = value;
    }

    public PropertyImpl(Object value, PropertyType type)
    {
        this.value = value;
        this.type = type;
    }

    public PropertyImpl(Object value, PropertyType type, Boolean isMultiValued)
    {
        this.value = value;
        this.type = type;
        this.isMultiValued = isMultiValued;
    }

    public PropertyImpl(String displayName, Object value, PropertyType type, Boolean isMultiValued)
    {
        this.displayName = displayName;
        this.value = value;
        this.type = type;
        this.isMultiValued = isMultiValued;
    }

    /** {@inheritDoc} */
    public boolean isMultiValued()
    {
        if (prop != null) { return prop.isMultiValued(); }
        if (isMultiValued != null) { return isMultiValued; }
        return false;
    }

    /** {@inheritDoc} */
    public PropertyType getType()
    {
        if (prop != null) { return PropertyType.fromValue(prop.getType().value()); }
        if (type != null) { return type; }
        return null;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public <T> T getValue()
    {
        if (prop != null) { return (T) prop.getValue(); }
        if (value != null) { return (T) value; }
        return null;
    }

    /** {@inheritDoc} */
    public String getDisplayName()
    {
        if (prop != null) { return prop.getDisplayName(); }
        if (displayName != null) { return displayName; }
        return null;
    }

    /**
     * @return Returns the string representation value for the property
     */
    public String getStringValue()
    {
        return formatValue(getValue());
    }

    // ////////////////////////////////////////////////////
    // INTERNAL
    // ////////////////////////////////////////////////////
    /**
     * Utility class to transform an object value to this String representation
     * value.
     *
     * @param object :
     * @return String value of this object.
     */
    private String formatValue(Object object)
    {
        String result;

        if (object == null) { return null; }

        if (object instanceof GregorianCalendar)
        {
            result = ((GregorianCalendar) object).getTime().toString();
        }
        else
        {
            result = object.toString();
        }
        return result;
    }
}

