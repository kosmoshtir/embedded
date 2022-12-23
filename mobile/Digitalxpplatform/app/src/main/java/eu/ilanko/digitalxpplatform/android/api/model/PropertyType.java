package eu.ilanko.digitalxpplatform.android.api.model;

public enum PropertyType
{

    STRING("String"), ID("Id"), INTEGER("Integer"), DECIMAL("Decimal"), DATETIME("DateTime"), BOOLEAN("Boolean");

    /** The value associated to an enum. */
    private final String value;

    /**
     * Instantiates a new property type.
     *
     * @param v the value of the enum.
     */
    PropertyType(String v)
    {
        value = v;
    }

    /**
     * Value.
     *
     * @return the string
     */
    public String value()
    {
        return value;
    }

    /**
     * From value.
     *
     * @param v the value of the enum.
     * @return the property type
     */
    public static PropertyType fromValue(String v)
    {
        for (PropertyType c : PropertyType.values())
        {
            if (c.value.equalsIgnoreCase(v)) { return c; }
        }
        throw new IllegalArgumentException(v);
    }
}
