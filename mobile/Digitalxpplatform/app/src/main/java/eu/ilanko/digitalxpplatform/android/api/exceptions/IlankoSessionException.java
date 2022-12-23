package eu.ilanko.digitalxpplatform.android.api.exceptions;

public class IlankoSessionException extends IlankoException{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     *
     * @param errorCode the error code
     * @param e the e
     */

    public IlankoSessionException(int errorCode, Throwable e)
    {
        super(errorCode, e);
    }

    /**
     * Instantiates a new Ilanko session exception.
     *
     * @param errorCode Mobile SDK error code
     * @param message the message associated to this exception.
     */
    public IlankoSessionException(int errorCode, String message)
    {
        super(errorCode, message);
    }

    /**
     * Instantiates a new Ilanko session exception.
     *
     * @param errorCode Mobile SDK error code
     * @param content IlankoErrorContent object associated to this exception
     */
    public IlankoSessionException(int errorCode, IlankoErrorContent content)
    {
        super(errorCode, content);
    }
}
