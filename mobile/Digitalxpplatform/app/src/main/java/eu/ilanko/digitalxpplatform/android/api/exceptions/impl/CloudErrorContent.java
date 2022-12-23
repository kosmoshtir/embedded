package eu.ilanko.digitalxpplatform.android.api.exceptions.impl;
import java.math.BigInteger;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.constants.CloudConstant;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoErrorContent;
import eu.ilanko.digitalxpplatform.android.api.utils.JsonUtils;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class CloudErrorContent implements IlankoErrorContent
{

    /** The HTTP error code. */
    private int code;

    /** The message associated to the exception. */
    private String message;

    /** The callstack. */
    private String callstack;

    /** The description url. */
    private String descriptionURL;

    /**
     * Parses json exception response and try to retrieve essential values.
     *
     * @param errorContentValue the raw data from the HTTP request.
     * @return the cloud error content object.
     */
    @SuppressWarnings("unchecked")
    public static CloudErrorContent parseJson(String errorContentValue)
    {
        Map<String, Object> json = null;
        try
        {
            json = JsonUtils.parseObject(errorContentValue);
            json = (Map<String, Object>) json.get(CloudConstant.ERROR_VALUE);
        }
        catch (Exception e)
        {
            return null;
        }

        CloudErrorContent errorContent = new CloudErrorContent();
        BigInteger code = JSONConverter.getInteger(json, CloudConstant.STATUSCODE_VALUE);
        if (code == null) { return null; }
        errorContent.code = code.intValue();
        errorContent.message = JSONConverter.getString(json, CloudConstant.BRIEFSUMMARY_VALUE);
        errorContent.callstack = JSONConverter.getString(json, CloudConstant.STACKTRACE_VALUE);
        errorContent.descriptionURL = JSONConverter.getString(json, CloudConstant.DESCRIPTIONURL_VALUE);
        return errorContent;
    }

    /** {@inheritDoc} */
    public int getCode()
    {
        return code;
    }

    /** {@inheritDoc} */
    public String getMessage()
    {
        return message;
    }

    /** {@inheritDoc} */
    public String getStackTrace()
    {
        return callstack;
    }

    /**
     * Gets the description url associated to this error message.
     *
     * @return the description url
     */
    public String getDescriptionURL()
    {
        return descriptionURL;
    }
}

