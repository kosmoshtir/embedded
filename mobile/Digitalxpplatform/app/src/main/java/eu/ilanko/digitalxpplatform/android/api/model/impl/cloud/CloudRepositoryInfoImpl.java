package eu.ilanko.digitalxpplatform.android.api.model.impl.cloud;
import eu.ilanko.digitalxpplatform.android.api.constants.CloudConstant;
import eu.ilanko.digitalxpplatform.android.api.model.RepositoryCapabilities;
import eu.ilanko.digitalxpplatform.android.api.model.impl.AbstractRepositoryInfo;
public class CloudRepositoryInfoImpl extends AbstractRepositoryInfo
{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor that wrapp RepositoryInfo CMIS object .
     *
     * @param repositoryInfo : cmis object.
     * @param rootNode
     */
    public CloudRepositoryInfoImpl(org.apache.chemistry.opencmis.commons.data.RepositoryInfo repositoryInfo)
    {
        super(repositoryInfo);
    }

    /**
     * Returns the version of the repository.
     */
    public String getVersion()
    {
        return null;
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the major version of the repository
     */
    public Integer getMajorVersion()
    {
        return -1;
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the minor version of the repository
     */
    public Integer getMinorVersion()
    {
        return -1;
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the maintenance version of the repository
     */
    public Integer getMaintenanceVersion()
    {
        return -1;
    }

    /**
     * Pattern : major.minor.maintenance (build)
     *
     * @return Returns the build number as string.
     */
    public String getBuildNumber()
    {
        return null;
    }

    /**
     * Returns Community or Enterprise if it's an Ilanko Repository. Returns
     * product name if it's a CMIS server.
     *
     * @return null if it's not an Ilanko repository.
     */
    public String getEdition()
    {
        return CloudConstant.ILANKO_EDITION_CLOUD;
    }

    /**
     * Check if the repository is an Ilanko Repository.
     *
     * @return true if Ilanko product.
     */
    public boolean isIlankoProduct()
    {
        return true;
    }

    @Override
    public RepositoryCapabilities getCapabilities()
    {
        if (capabilities == null)
        {
            capabilities = new CloudRepositoryCapabilitiesImpl();
        }
        return capabilities;
    }
}
