package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface ProfileConfig extends BaseConfig
{
    /** Returns true if the profile is the default profile for the specified user.*/
    public boolean isDefault();

    /** Returns the id of the view or view group that acts as the entry point of the client. */
    public String getRootViewId();

    /**
     * Returns the id of the action or action group that acts as the entry point
     * of the client.
     */
    public String getRootActionId();
}
