package eu.ilanko.digitalxpplatform.android.api.model.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.constants.CloudConstant;
import eu.ilanko.digitalxpplatform.android.api.model.Tag;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class TagImpl implements Tag
{
    private static final long serialVersionUID = 1L;

    /** Unique identifier to a specific tag. */
    private String identifier;

    /** Value of the tag. */
    private String value;

    /**
     * Instantiates a new tag impl.
     */
    public TagImpl()
    {
    }

    /**
     * Instantiates a new tag impl.
     *
     * @param value the value of the tag
     */
    public TagImpl (String value)
    {
        this.identifier = null;
        if (value.startsWith("\"") && value.endsWith("\"")){
            this.value = value.replaceAll("\"", "");
        } else {
            this.value = value;
        }
    }

    /**
     * Parse Json Response from Ilanko Public API to create a Site.
     *
     * @param jo the jo
     * @return Tag object that contains essential information about it.
     */
    public static Tag parsePublicAPIJson(Map<String, Object> jo)
    {
        TagImpl tagItem = new TagImpl();
        tagItem.identifier = JSONConverter.getString(jo, CloudConstant.ID_VALUE);
        tagItem.value = JSONConverter.getString(jo, CloudConstant.TAG_VALUE);
        return tagItem;
    }

    /** {@inheritDoc} */
    public String getIdentifier()
    {
        return identifier;
    }

    /** {@inheritDoc} */
    public String getValue()
    {
        return value;
    }

}

