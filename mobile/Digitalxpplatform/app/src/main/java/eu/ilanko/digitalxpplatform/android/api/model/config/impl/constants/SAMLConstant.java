package eu.ilanko.digitalxpplatform.android.api.model.config.impl.constants;

public interface SAMLConstant
{
    /** Root Url path for default tenant. */

    /** Root Url path for default tenant. */
    String SAMLV2_RESTAPI_ROOTPATH = "/service/saml/-default-/rest-api";

    /** Url path to check if SAML is enabled. */
    String SMALV2_RESTAPI_ENABLED_PATH = SAMLV2_RESTAPI_ROOTPATH + "/enabled";

    /** Url path to request authentication. */
    String SMALV2_RESTAPI_AUTHENTICATE_PATH = SAMLV2_RESTAPI_ROOTPATH + "/authenticate";

    /** Url path to receive authentication token. */
    String SMALV2_RESTAPI_AUTHENTICATE_RESPONSE_PATH = SAMLV2_RESTAPI_ROOTPATH + "/authenticate-response";

}
