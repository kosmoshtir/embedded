package eu.ilanko.digitalxpplatform.android.api.model.config.impl.constants;

public interface OAuthConstant
{
    /** Public API URL. */
    String PUBLIC_API_HOSTNAME = "https://api.ilanko.eu";

    /** Url path to initiate Authentication against Public API. */
    String PUBLIC_API_OAUTH_AUTHORIZE_PATH = "/auth/oauth/versions/2/authorize";

    /** Entry Point to initiate Authentication against Public API. */
    String PUBLIC_API_OAUTH_AUTHORIZE_URL = PUBLIC_API_HOSTNAME + PUBLIC_API_OAUTH_AUTHORIZE_PATH;

    /** Url path to initiate Authentication against Public API. */
    String PUBLIC_API_OAUTH_TOKEN_PATH = "/auth/oauth/versions/2/token";

    /** Entry Point to get OAuth Authentication Token against Public API. */
    String PUBLIC_API_OAUTH_TOKEN_URL = PUBLIC_API_HOSTNAME + PUBLIC_API_OAUTH_TOKEN_PATH;

    /** Default Mobile Public API URL Callback. */
    String PUBLIC_API_OAUTH_DEFAULT_CALLBACK = "http://www.ilanko.eu/mobile-auth-callback.html";


}
