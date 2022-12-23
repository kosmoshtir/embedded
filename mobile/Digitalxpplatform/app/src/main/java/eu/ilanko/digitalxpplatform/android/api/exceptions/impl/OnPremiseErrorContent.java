package eu.ilanko.digitalxpplatform.android.api.exceptions.impl;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.constants.OnPremiseConstant;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoErrorContent;
import eu.ilanko.digitalxpplatform.android.api.utils.JsonUtils;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class OnPremiseErrorContent implements IlankoErrorContent
{

    /** The HTTP error code. */
    private int code;

    /** The message. */
    private String message;

    /** The exception raised by the server. */
    private String exception;

    /** The callstack. */
    private String callstack;

    /**
     * Parses the json.
     *
     * @param errorContentValue the error content value
     * @return the on premise error content
     */
    @SuppressWarnings("unchecked")
    public static OnPremiseErrorContent parseJson(String errorContentValue)
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

        OnPremiseErrorContent errorContent = new OnPremiseErrorContent();

        Map<String, Object> jo = (Map<String, Object>) json.get(OnPremiseConstant.STATUS_VALUE);
        errorContent.code = JSONConverter.getInteger(jo, OnPremiseConstant.CODE_VALUE).intValue();

        errorContent.message = JSONConverter.getString(json, OnPremiseConstant.MESSAGE_VALUE);
        errorContent.exception = JSONConverter.getString(json, OnPremiseConstant.EXCEPTION_VALUE);
        List<String> s = (List<String>) json.get(OnPremiseConstant.CALLSTACK_VALUE);
        if (s != null)
        {
            errorContent.callstack = s.toString();
        }
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

    /**
     * Gets the exception.
     *
     * @return the exception
     */
    public String getException()
    {
        return exception;
    }

    /** {@inheritDoc} */
    public String getStackTrace()
    {
        return callstack;
    }

}

