package eu.ilanko.digitalxpplatform.android.api.model.config;
import java.util.Map;
public interface ItemConfig extends BaseConfig
{
    /**
     * Returns the identifier for an icon to use for the item.
     *
     * @return
     */
    String getIconIdentifier();

    /**
     * Returns the type of the item.
     *
     * @return
     */
    String getType();

    /**
     * Returns the parameters for the item, these will typically depend on the
     * type of item.
     *
     * @return
     */
    Map<String, Object> getParameters();

    /**
     * Returns the value of the parameter with the given key or null if it
     * doesn’t exist.
     *
     * @param key
     * @return
     */
    Object getParameter(String key);
}
