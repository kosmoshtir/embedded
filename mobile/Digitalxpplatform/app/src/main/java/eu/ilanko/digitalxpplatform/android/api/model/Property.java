package eu.ilanko.digitalxpplatform.android.api.model;
import java.io.Serializable;
public interface Property extends Serializable
{

    /**
     * Returns true if the property is a multi-value property.
     *
     * @return true, if is multi valued
     */
    boolean isMultiValued();

    /**
     * Returns the property data type.
     *
     * @return the type
     */
    PropertyType getType();

    /**
     * Return the display Name
     * @return
     */
    String getDisplayName();

    /**
     * Returns the property value, in the case of a multi-valued property a List
     * is returned.
     *
     * @param <T> the generic type
     * @return the value
     */
    <T> T getValue();
}

