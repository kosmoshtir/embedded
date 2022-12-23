package eu.ilanko.digitalxpplatform.android.api.exceptions;

public class IlankoServiceException extends IlankoException{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     *
     * @param detailsMessage the details message of the exception
     */
    public IlankoServiceException(String detailsMessage)
    {
        super(detailsMessage);
    }

    /**
     * Instantiates a new Ilanko service exception.
     *
     * @param message Exception message
     * @param errorContent the error content (raw value from the server)
     */
    public IlankoServiceException(String message, String errorContent)
    {
        super(message, errorContent);
    }

    /**
     * Instantiates a new Ilanko service exception.
     *
     * @param errorCode the error code
     * @param e Exception encapsulate by this new exception
     */
    public IlankoServiceException(int errorCode, Throwable e)
    {
        super(errorCode, e);
    }

    /**
     * Instantiates a new Ilanko service exception.
     *
     * @param errorCode Mobile SDK error code
     * @param message message associated to this exception
     */
    public IlankoServiceException(int errorCode, String message)
    {
        super(errorCode, message);
    }

    /**
     * Instantiates a new Ilanko service exception.
     *
     * @param errorCode Mobile SDK  error code
     * @param content IlankoErrorContent object associated to this exception.
     */
    public IlankoServiceException(int errorCode, IlankoErrorContent content)
    {
        super(errorCode, content);
    }
}
