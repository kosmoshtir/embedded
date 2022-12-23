package eu.ilanko.digitalxpplatform.android.api.model.impl.onpremise;
import eu.ilanko.digitalxpplatform.android.api.constants.OnPremiseConstant;
import eu.ilanko.digitalxpplatform.android.api.model.OperatorType;
import eu.ilanko.digitalxpplatform.android.api.model.RepositoryInfo;
import eu.ilanko.digitalxpplatform.mobile.android.api.model.impl.AbstractRepositoryCapabilities;
import eu.ilanko.digitalxpplatform.mobile.android.api.model.impl.RepositoryVersionHelper;

import android.text.TextUtils;
public class OnPremiseRepositoryCapabilitiesImpl extends AbstractRepositoryCapabilities
{
    private static final long serialVersionUID = 1L;

    private RepositoryInfo repositoryInfo;

    /**
     * Constructor that wrap RepositoryInfo CMIS object .
     *
     * @param repositoryInfo : cmis object.
     * @param rootNode
     */
    public OnPremiseRepositoryCapabilitiesImpl(RepositoryInfo repositoryInfo)
    {
        this.repositoryInfo = repositoryInfo;
        capabilities.put(CAPABILITY_LIKE, supportLikingNodes());
        capabilities.put(CAPABILITY_COMMENTS_COUNT, supportCommentsCount());
    }

    /**
     * Like action and LikeService are only available since Ilanko V4. This
     * flag indicate if this feature is available with the current repository.
     * NB : It's a simple test based on repository Informations version and
     * edition.
     *
     * @return true if version 4 or superior of Ilanko. false in other case.
     */
    private boolean supportLikingNodes()
    {
        if (!((OnPremiseRepositoryInfoImpl) repositoryInfo).isIlankoProduct()) { return false; }
        return (repositoryInfo.getMajorVersion() >= OnPremiseConstant.Ilanko_VERSION_4);
    }

    /**
     * Comment count is only available since Ilanko V4. This flag indicate if
     * this feature is available with the current repository. NB : It's a simple
     * test based on repository informations version and edition.
     *
     * @return true if version 4 or superior of Ilanko. false in other case.
     */
    private boolean supportCommentsCount()
    {
        if (!((OnPremiseRepositoryInfoImpl) repositoryInfo).isIlankoProduct()) { return false; }
        return (repositoryInfo.getMajorVersion() >= OnPremiseConstant.Ilanko_VERSION_4);
    }

    @Override
    public boolean doesSupportPublicAPI()
    {
        return ((OnPremiseRepositoryInfoImpl) repositoryInfo).hasPublicAPI;
    }

    @Override
    public boolean doesSupportActivitiWorkflowEngine()
    {
        return (repositoryInfo.getMajorVersion() >= OnPremiseConstant.Ilanko_VERSION_4);
    }

    @Override
    public boolean doesSupportJBPMWorkflowEngine()
    {
        if (doesSupportPublicAPI())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean doesSupportMyFiles()
    {
        if (!((OnPremiseRepositoryInfoImpl) repositoryInfo).isIlankoProduct()) { return false; }

        return evaluateRepositoryVersion(OnPremiseConstant.Ilanko_EDITION_ENTERPRISE, OperatorType.SUPERIOR_OR_EQUAL,
                4, 2, null)
                || evaluateRepositoryVersion(OnPremiseConstant.Ilanko_EDITION_COMMUNITY,
                OperatorType.SUPERIOR_OR_EQUAL, 4, 2, "e");
    }

    @Override
    public boolean doesSupportSharedFiles()
    {
        if (!((OnPremiseRepositoryInfoImpl) repositoryInfo).isIlankoProduct()) { return false; }
        return evaluateRepositoryVersion(OnPremiseConstant.Ilanko_EDITION_ENTERPRISE, OperatorType.SUPERIOR_OR_EQUAL,
                4, 2, null)
                || evaluateRepositoryVersion(OnPremiseConstant.Ilanko_EDITION_COMMUNITY,
                OperatorType.SUPERIOR_OR_EQUAL, 4, 2, "e");
    }

    public boolean evaluateRepositoryVersion(String edition, OperatorType operatorValue, Integer majorVersion,
                                             Integer minorVersion, String maintenanceVersion)
    {
        boolean result = true;

        // Edition
        if (!TextUtils.isEmpty(edition))
        {
            result = repositoryInfo.getEdition().equalsIgnoreCase(edition);
        }

        if (!result) { return false; }

        OperatorType operator = OperatorType.EQUAL;
        if (operatorValue != null)
        {
            operator = operatorValue;
        }

        int versionNumber = 0;
        int repoVersionNumber = 0;
        // Major Version
        if (majorVersion != null)
        {
            versionNumber += 100 * majorVersion;
            repoVersionNumber += 100 * repositoryInfo.getMajorVersion();
        }

        // Minor Version
        if (minorVersion != null)
        {
            versionNumber += 10 * minorVersion;
            repoVersionNumber += 10 * repositoryInfo.getMinorVersion();
        }

        // Maintenance Version
        if (maintenanceVersion != null)
        {
            if (OnPremiseConstant.Ilanko_EDITION_ENTERPRISE.equals(repositoryInfo.getEdition()))
            {
                versionNumber += Integer.parseInt(maintenanceVersion);
                repoVersionNumber += repositoryInfo.getMaintenanceVersion();
            }
            else
            {
                return evaluate(operator, RepositoryVersionHelper.getVersionString(repositoryInfo.getVersion(), 2),
                        maintenanceVersion);
            }
        }

        result = evaluate(operator, repoVersionNumber, versionNumber);

        return result;
    }

    private boolean evaluate(OperatorType operator, int value, int valueExpected)
    {
        switch (operator)
        {
            case INFERIOR:
                return value < valueExpected;
            case INFERIOR_OR_EQUAL:
                return value <= valueExpected;
            case SUPERIOR_OR_EQUAL:
                return value >= valueExpected;
            case SUPERIOR:
                return value > valueExpected;
            default:
                return value == valueExpected;
        }
    }

    private boolean evaluate(OperatorType operator, String value, String valueExpected)
    {
        int compareValue = value.compareTo(valueExpected);
        switch (operator)
        {
            case INFERIOR:
                return compareValue < 0;
            case INFERIOR_OR_EQUAL:
                return compareValue <= 0;
            case SUPERIOR_OR_EQUAL:
                return compareValue >= 0;
            case SUPERIOR:
                return compareValue > 0;
            default:
                return compareValue == 0;
        }
    }
}

