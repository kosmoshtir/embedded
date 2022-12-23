package eu.ilanko.digitalxpplatform.android.api.exceptions.impl;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoErrorContent;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoException;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoServiceException;
import eu.ilanko.digitalxpplatform.android.api.exceptions.IlankoSessionException;
import eu.ilanko.digitalxpplatform.android.api.exceptions.ErrorCodeRegistry;
import eu.ilanko.digitalxpplatform.android.api.session.IlankoSession;
import eu.ilanko.digitalxpplatform.android.api.session.CloudSession;
import eu.ilanko.digitalxpplatform.android.api.session.RepositorySession;
import org.apache.chemistry.opencmis.client.bindings.spi.http.Response;
import org.apache.chemistry.opencmis.commons.exceptions.CmisBaseException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConstraintException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisInvalidArgumentException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisPermissionDeniedException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisRuntimeException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisUnauthorizedException;
import org.apache.http.HttpStatus;
public final class ExceptionHelper
{

    /**
     * Instantiates a new exception helper.
     */
    private ExceptionHelper()
    {
    }

    /**
     * Convert exception into IlankoServiceException.
     *
     * @param exception the underlying exception from OpenCMIS or generic
     *            exception.
     */
    public static void convertException(Exception exception)
    {
        try
        {
            throw exception;
        }
        catch (IlankoException e)
        {
            throw (IlankoException) e;
        }
        catch (CmisUnauthorizedException e)
        {
            throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_ACCESS_DENIED, e);
        }
        catch (CmisRuntimeException e)
        {
            if (e.getErrorContent() != null && e.getErrorContent().contains("cannot be null or empty."))
            {
                throw new IllegalArgumentException(e);
            }
            else if (e.getErrorContent() != null && e.getErrorContent().contains("Access is denied."))
            {
                throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_ACCESS_DENIED, e);
            }
            else
            {
                throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_GENERIC, e);
            }
        }
        catch (CmisConstraintException e)
        {
            if (e.getMessage().contains("Conflict"))
            {
                throw new IlankoServiceException(ErrorCodeRegistry.DOCFOLDER_NODE_ALREADY_EXIST, e);
            }
            else
            {
                throw new IllegalArgumentException(e);
            }
        }
        catch (CmisObjectNotFoundException e)
        {
            throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_NODE_NOT_FOUND, e);
        }
        catch (CmisContentAlreadyExistsException e)
        {
            throw new IlankoServiceException(ErrorCodeRegistry.DOCFOLDER_NODE_ALREADY_EXIST, e);
        }
        catch (CmisPermissionDeniedException e)
        {
            throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_ACCESS_DENIED, e);
        }
        catch (CmisInvalidArgumentException e)
        {
            throw new IllegalArgumentException(e);
        }
        catch (CmisBaseException cmisException)
        {
            throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_GENERIC, cmisException);
        }
        catch (Exception e)
        {
            throw new IlankoServiceException(ErrorCodeRegistry.GENERAL_GENERIC, e);
        }
    }

    /**
     * Convert an HTTP error response (404 instead of 200 for example) into a
     * generic exception.
     *
     * @param session the Ilanko session associated to the exception.
     * @param resp the HTTP response from the server.
     * @param serviceErrorCode the service error code associated.
     */
    public static void convertStatusCode(IlankoSession session, Response resp, int serviceErrorCode)
    {
        IlankoErrorContent er = null;
        if (session instanceof RepositorySession)
        {
            if (resp.getResponseCode() == HttpStatus.SC_UNAUTHORIZED)
            {
                throw new CmisUnauthorizedException();
            }

            try
            {
                er = OnPremiseErrorContent.parseJson(resp.getErrorContent());
            }
            catch (Exception ee)
            {
                // No format...
                er = null;
            }
        }
        else if (session instanceof CloudSession || session == null)
        {
            if (resp.getResponseCode() == HttpStatus.SC_UNAUTHORIZED)
            {
                er = OAuthErrorContent.parseJson(resp.getErrorContent());
            }
            else if (resp.getResponseCode() == HttpStatus.SC_BAD_REQUEST && session == null)
            {
                throw new IlankoSessionException(serviceErrorCode,
                        OAuthErrorContent.parseJson(resp.getErrorContent()));
            }
            else if (resp.getResponseCode() == HttpStatus.SC_SERVICE_UNAVAILABLE && session == null) { throw new IlankoSessionException(
                    ErrorCodeRegistry.GENERAL_HTTP_RESP, HttpStatus.SC_SERVICE_UNAVAILABLE + " "
                    + resp.getErrorContent()); }

            if (er == null)
            {
                try
                {
                    er = CloudErrorContent.parseJson(resp.getErrorContent());
                    if (er == null)
                    {
                        er = OnPremiseErrorContent.parseJson(resp.getErrorContent());
                    }
                }
                catch (Exception e)
                {
                    try
                    {
                        er = OnPremiseErrorContent.parseJson(resp.getErrorContent());
                    }
                    catch (Exception ee)
                    {
                        // No format...
                        er = null;
                    }
                }
            }
        }
        if (er != null)
        {
            if (er instanceof OAuthErrorContent)
            {
                throw new IlankoSessionException(ErrorCodeRegistry.SESSION_ACCESS_TOKEN_EXPIRED, er);
            }
            else
            {
                throw new IlankoServiceException(serviceErrorCode, er);
            }
        }
        else
        {
            throw new IlankoServiceException(serviceErrorCode, resp.getErrorContent());
        }
    }

}
