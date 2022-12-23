package eu.ilanko.digitalxpplatform.android.api.model.config;

public enum EvaluatorType
{
    NODE_TYPE("eu.ilanko.digitalxpplatform.client.evaluator.nodeType"),
    HAS_ASPECT("eu.ilanko.digitalxpplatform.client.evaluator.hasAspect"),
    HAS_REPOSITORY_CAPABILITY("eu.ilanko.digitalxpplatform.client.evaluator.hasRepositoryCapability"),
    HAS_PROPERTY_VALUE("eu.ilanko.digitalxpplatform.client.evaluator.hasPropertyValue"),
    IS_USER("eu.ilanko.digitalxpplatform.client.evaluator.isUser");

    /** The value associated to an enum. */
    private final String value;

    /**
     * Instantiates a new property type.
     *
     * @param v the value of the enum.
     */
    EvaluatorType(String v)
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
    public static EvaluatorType fromValue(String v)
    {
        for (EvaluatorType c : EvaluatorType.values())
        {
            if (c.value.equalsIgnoreCase(v)) { return c; }
        }
        return null;
    }
}

