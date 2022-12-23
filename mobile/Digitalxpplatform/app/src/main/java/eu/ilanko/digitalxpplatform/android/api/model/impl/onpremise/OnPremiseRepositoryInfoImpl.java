package eu.ilanko.digitalxpplatform.android.api.model.impl.onpremise;
import eu.ilanko.digitalxpplatform.android.api.constants.OnPremiseConstant;
import eu.ilanko.digitalxpplatform.android.api.model.RepositoryCapabilities;
import eu.ilanko.digitalxpplatform.mobile.android.api.model.impl.AbstractRepositoryInfo;
import eu.ilanko.digitalxpplatform.mobile.android.api.model.impl.RepositoryVersionHelper;
public class OnPremiseRepositoryInfoImpl extends AbstractRepositoryInfo
{

    private static final long serialVersionUID = 1L;

    private String edition = null;

    boolean hasPublicAPI = false;

    /**
     * Constructor that wrapp RepositoryInfo CMIS object .
     *
     * @param repositoryInfo : cmis object.
     * @param rootNode
     */
    public OnPremiseRepositoryInfoImpl(org.apache.chemistry.opencmis.commons.data.RepositoryInfo repositoryInfo)
    {
        super(repositoryInfo);
    }

    public OnPremiseRepositoryInfoImpl(org.apache.chemistry.opencmis.commons.data.RepositoryInfo repositoryInfo,
                                       boolean hasPublicAPI)
    {
        super(repositoryInfo);
        this.hasPublicAPI = hasPublicAPI;
    }

    /**
     * Specific constructor to support MOBSDK-508 issue.
     *
     * @param repositoryInfo : cmis object.
     * @param editionValue : Override this specific value.
     */
    public OnPremiseRepositoryInfoImpl(org.apache.chemistry.opencmis.commons.data.RepositoryInfo repositoryInfo,
                                       String editionValue)
    {
        super(repositoryInfo);
        edition = editionValue;
    }

    /**
     * Returns the version of the repository.
     */
    public String getVersion()
    {
        return repositoryInfo.getProductVersion();
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the major version of the repository
     */
    public Integer getMajorVersion()
    {
        return RepositoryVersionHelper.getVersion(getVersion(), 0);
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the minor version of the repository
     */
    public Integer getMinorVersion()
    {
        return RepositoryVersionHelper.getVersion(getVersion(), 1);
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the maintenance version of the repository
     */
    public Integer getMaintenanceVersion()
    {
        int separator = RepositoryVersionHelper.getVersionString(getVersion(), 2).indexOf(' ');
        return Integer.parseInt(RepositoryVersionHelper.getVersionString(getVersion(), 2).substring(0, separator));
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the build number as string.
     */
    public String getBuildNumber()
    {
        int separator = RepositoryVersionHelper.getVersionString(getVersion(), 2).indexOf(' ');
        return RepositoryVersionHelper.getVersionString(getVersion(), 2).substring(separator);
    }

    /**
     * Returns Community or Enterprise if it's an Ilanko Repository. Returns
     * product name if it's a CMIS server.
     *
     * @return null if it's not an Ilanko repository.
     */
    public String getEdition()
    {
        // Related to MOBSDK-508 issue.
        if (edition != null) { return edition; }

        // In normal case
        if (repositoryInfo.getProductName().startsWith(OnPremiseConstant.Ilanko_VENDOR))
        {
            if (repositoryInfo.getProductName().contains(OnPremiseConstant.Ilanko_EDITION_ENTERPRISE))
            {
                return OnPremiseConstant.Ilanko_EDITION_ENTERPRISE;
            }
            else if (repositoryInfo.getProductName().contains(OnPremiseConstant.Ilanko_EDITION_COMMUNITY))
            {
                return OnPremiseConstant.Ilanko_EDITION_COMMUNITY;
            }
            else
            {
                return OnPremiseConstant.Ilanko_EDITION_UNKNOWN;
            }
        }
        else
        {
            return repositoryInfo.getProductName();
        }
    }

    /**
     * Check if the repository is an Ilanko Repository.
     *
     * @return true if Ilanko product.
     */
    public boolean isIlankoProduct()
    {
        if (repositoryInfo.getProductName() == null) { return false; }
        return repositoryInfo.getProductName().startsWith(OnPremiseConstant.Ilanko_VENDOR);
    }

    @Override
    public RepositoryCapabilities getCapabilities()
    {
        if (capabilities == null)
        {
            capabilities = new OnPremiseRepositoryCapabilitiesImpl(this);
        }
        return capabilities;
    }
}

