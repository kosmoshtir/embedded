package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import eu.ilanko.digitalxpplatform.android.api.model.config.RepositoryConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class RepositoryConfigImpl implements RepositoryConfig
{
    private String shareUrl;

    private String repoCMISUrl;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    static RepositoryConfigImpl parseJson(Map<String, Object> json)
    {
        if (json == null || json.isEmpty()) { return null; }
        RepositoryConfigImpl repoConfig = new RepositoryConfigImpl();

        repoConfig.shareUrl = JSONConverter.getString(json, ConfigConstants.SHARE_URL_VALUE);
        repoConfig.repoCMISUrl = JSONConverter.getString(json, ConfigConstants.CMIS_URL_VALUE);

        return repoConfig;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getShareURL()
    {
        return shareUrl;
    }

    @Override
    public String getCMISURL()
    {
        return repoCMISUrl;
    }
}

