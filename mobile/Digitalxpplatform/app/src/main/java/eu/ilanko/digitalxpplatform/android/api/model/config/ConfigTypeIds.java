package eu.ilanko.digitalxpplatform.android.api.model.config;

public enum ConfigTypeIds
{
    INFO("info"),
    REPOSITORY("repository"),
    VIEWS("views"),
    FORMS("forms"),
    CREATION("creation"),
    FEATURES(
            "features"), ACTIONS("actions"), ACTION_GROUPS("action-groups"),
    VIEW_GROUPS("view-groups"),
    FIELDS(
            "fields"), FIELD_GROUPS("field-groups"),
    EVALUATORS("evaluators"),
    VALIDATION_RULES("validation-rules"),
    PROFILES("profiles");


    /** The value associated to an enum. */
    private final String value;

    /**
     * Instantiates a new property type.
     *
     * @param v the value of the enum.
     */
    ConfigTypeIds(String v)
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
    public static ConfigTypeIds fromValue(String v)
    {
        for (ConfigTypeIds c : ConfigTypeIds.values())
        {
            if (c.value.equalsIgnoreCase(v)) { return c; }
        }
        return null;
    }
}
