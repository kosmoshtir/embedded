package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface RepositoryConfig
{
    /** Returns the protocol being used for Share. */
    String getShareURL();

    /** Returns the URL to be used to access CMIS services. */
    String getCMISURL();

}
