package eu.ilanko.digitalxpplatform.android.api.model.config;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConfigScope implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String PROFILE_IDENTIFIER = "ConfigScope.profileIdentifier";

    public static final String NODE_IDENTIFIER = "ConfigScope.nodeIdentifier";

    public static final String NODE = "ConfigScope.node";

    public static final String PERSON_IDENTIFIER = "ConfigScope.personId";

    public static final String SITE_IDENTIFIER = "ConfigScope.siteIdentifier";

    private Map<String, Object> mapValues;

    public ConfigScope(String profile)
    {
        this.mapValues = new HashMap<String, Object>(0);
        mapValues.put(PROFILE_IDENTIFIER, profile);
    }

    public ConfigScope(String profile, Map<String, Object> context)
    {
        mapValues = (context != null) ? new HashMap<String, Object>(context) : new HashMap<String, Object>(0);
        mapValues.put(PROFILE_IDENTIFIER, profile);
    }

    /**
     * Returns the identifier of the profile to be used.
     */
    public String getProfile()
    {
        return (String) mapValues.get(PROFILE_IDENTIFIER);
    }

    /**
     * @return the map containing all configuration information.
     */
    public Map<String, Object> getContext()
    {
        return new HashMap<String, Object>(mapValues);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * filter contains no mapping for the key.
     *
     * @param key
     * @return
     */
    public Object getContextValue(String key)
    {
        return mapValues.get(key);
    }

    /**
     * Add a specific key/value configuration.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    public void add(String key, Object value)
    {
        mapValues.put(key, value);
    }

    /**
     * Adds or replaces a map of context values.
     *
     */
    public void add(Map<String, Object> context)
    {
        if (context != null && !context.isEmpty())
        {
            mapValues.putAll(context);
        }
    }

}

