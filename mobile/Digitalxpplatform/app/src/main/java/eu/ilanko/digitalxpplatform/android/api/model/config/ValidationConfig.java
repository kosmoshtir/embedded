package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface ValidationConfig extends ItemConfig
{
    /** Returns the error message to display when this validation rule fails. */
    String getErrorMessage();
}