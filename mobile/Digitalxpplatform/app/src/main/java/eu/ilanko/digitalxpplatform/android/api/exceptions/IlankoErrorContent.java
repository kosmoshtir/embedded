package eu.ilanko.digitalxpplatform.android.api.exceptions;

public interface IlankoErrorContent {
    /**
     * Gets the HTTP Error code.
     *
     * @return HTTP Error code
     */
    int getCode();

    /**
     * Gets the main message from the error.
     *
     * @return Human readable message explaining the server side error.
     */
    String getMessage();

    /**
     * Gets the stack trace associated to the exception.
     *
     * @return StackTrace of the server side error.
     */
    String getStackTrace();
}
