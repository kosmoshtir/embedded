package eu.ilanko.digitalxpplatform.android.api.exceptions.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.constants.CloudConstant;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoErrorContent;
import eu.ilanko.digitalxpplatform.android.api.utils.JsonUtils;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
import org.apache.http.HttpStatus;

public class OAuthErrorContent implements IlankoErrorContent
{

    /** The message associated to the error. */
    private String message;

    /** The description associated to the error. */
    private String description;

    /**
     * Parses the json exception response and try to retrieve essential values.
     *
     * @param errorContentValue the raw data from the HTTP request.
     * @return the OAuth error content
     */
    public static OAuthErrorContent parseJson(String errorContentValue)
    {
        Map<String, Object> json = null;
        try
        {
            json = JsonUtils.parseObject(errorContentValue);
        }
        catch (Exception e)
        {
            return null;
        }

        OAuthErrorContent errorContent = null;
        if (json.containsKey(CloudConstant.ERROR_VALUE) || json.containsKey(CloudConstant.ERRORDESCRIPTION_VALUE))
        {
            errorContent = new OAuthErrorContent();
            errorContent.message = JSONConverter.getString(json, CloudConstant.ERROR_VALUE);
            errorContent.description = JSONConverter.getString(json, CloudConstant.ERRORDESCRIPTION_VALUE);
        }
        return errorContent;
    }

    /** {@inheritDoc} */
    @Override
    public int getCode()
    {
        return HttpStatus.SC_UNAUTHORIZED;
    }

    /** {@inheritDoc} */
    @Override
    public String getMessage()
    {
        return message;
    }

    /** {@inheritDoc} */
    @Override
    public String getStackTrace()
    {
        return null;
    }

    /**
     * Gets the description.
     *
     * @return the description associated to the OAuth Exception.
     */
    public String getDescription()
    {
        return description;
    }
}

