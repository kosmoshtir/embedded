package eu.ilanko.digitalxpplatform.android.api.exceptions;

public abstract class IlankoException extends RuntimeException implements ErrorCodeRegistry{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** Content the of the error page returned by server. */
    private String errorContent;

    /** Error Code. */
    private int errorCode;

    /** The Ilanko error content object associated to the exception. */
    private IlankoErrorContent ilankoErrorContent;


    /**
     * Default constructor.
     *
     * @param detailsMessage the details message from the exception
     */
    protected IlankoException(String detailsMessage)
    {
        super(detailsMessage);
    }

    /**
     * Default constructor.
     *
     * @param errorCode Mobile SDK error code
     * @param throwable Associated exception
     */
    protected IlankoException(int errorCode, Throwable throwable)
    {
        super(throwable);
        this.errorCode = errorCode;
    }

    /**
     * Constructor.
     *
     * @param message error message
     * @param errorContent error page content
     */
    protected IlankoException(String message, String errorContent)
    {
        super(message);
        this.errorContent = errorContent;
    }

    /**
     * Instantiates a new Ilanko exception.
     *
     * @param errorCode Mobile SDK error code
     * @param message Specific message associated to this error.
     */
    public IlankoException(int errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new Ilanko exception.
     *
     * @param errorCode Mobile SDK  code
     * @param errorContent Information from server side.
     */
    public IlankoException(int errorCode, IlankoErrorContent errorContent)
    {
        super(errorContent.getMessage());
        this.errorCode = errorCode;
        this.ilankoErrorContent = errorContent;
    }

    /**
     * Returns the content of the error page sent by the server.
     *
     * @return the content of the error page or <code>null</code> if the server
     * didn't send text content.
     */
    public String getErrorContent()
    {
        return errorContent;
    }

    /**
     * Error code send by the API.
     *
     * @return the error code.
     */
    public int getErrorCode()
    {
        return errorCode;
    }

    /**
     * Gets the Ilanko error content associated to the exception.
     *
     * @return the Ilanko error content
     */
    public IlankoErrorContent getIlankoErrorContent()
    {
        return ilankoErrorContent;
    }
}
