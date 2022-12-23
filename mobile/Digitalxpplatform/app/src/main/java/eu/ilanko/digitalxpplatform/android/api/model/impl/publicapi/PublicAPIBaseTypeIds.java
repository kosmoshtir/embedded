package eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi;

public enum PublicAPIBaseTypeIds
{
    DOCUMENT("file"), FOLDER("folder");

    private final String value;

    PublicAPIBaseTypeIds(String v)
    {
        value = v;
    }

    public String value()
    {
        return value;
    }

    public static PublicAPIBaseTypeIds fromValue(String v)
    {
        for (PublicAPIBaseTypeIds c : PublicAPIBaseTypeIds.values())
        {
            if (c.value.equals(v)) { return c; }
        }
        throw new IllegalArgumentException(v);
    }
}
