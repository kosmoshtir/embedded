package eu.ilanko.digitalxpplatform.android.api.model.impl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.ilanko.digitalxpplatform.android.api.model.impl.onpremise.OnPremiseRepositoryInfoImpl;
import eu.ilanko.digitalxpplatform.android.api.session.IlankoSession;
import eu.ilanko.digitalxpplatform.android.api.session.CloudSession;
import eu.ilanko.digitalxpplatform.android.api.session.RepositorySession;
public final class RepositoryVersionHelper
{

    // ////////////////////////////////////////////////////////////////////////////////////
    // Internal
    // ////////////////////////////////////////////////////////////////////////////////////
    private static final Pattern VERSIONPATTERN = Pattern.compile("\\d*\\d*\\d*.*");

    private RepositoryVersionHelper()
    {

    }

    /**
     * Internal methods to have the specific number version (major, minor,
     * maintenance)
     *
     * @param level : Major : 0, Minor : 1, Maintenance : 2, Build number : 3
     * @return Version Label of the specific level.
     */
    public static String getVersionString(String productVersion, int level)
    {
        if (!isVersion(productVersion)) { return null; }
        String[] versions = productVersion.split("\\.");
        if (versions.length >= level + 1) { return versions[level]; }
        return null;
    }

    /**
     * Internal methods to have the specific number version (major, minor,
     * maintenance)
     *
     * @param productVersion : Product version of the repository.
     * @param level : Major : 0, Minor : 1, Maintenance : 2, Build number : 3
     * @return Version int of the specific level.
     */
    public static Integer getVersion(String productVersion, int level)
    {
        String version = getVersionString(productVersion, level);
        if (version != null)
        {
            return Integer.parseInt(version);
        }
        else
        {
            return null;
        }
    }

    /**
     * Determine if version respect the pattern. If not, it's not possible to
     * get the version number.
     */
    private static boolean isVersion(String productVersion)
    {
        Matcher matcher = VERSIONPATTERN.matcher(productVersion);
        return matcher.matches();
    }

    /**
     * @param repoSession : Session associated to the repository.
     * @return true if it's the repository is an ILANKO repository.
     */
    public static boolean isIlankoProduct(IlankoSession repoSession)
    {
        if (repoSession == null) { return false; }

        if (repoSession instanceof CloudSession)
        {
            return true;
        }
        else if (repoSession instanceof RepositorySession && repoSession.getRepositoryInfo() != null)
        {
            return (((OnPremiseRepositoryInfoImpl) repoSession.getRepositoryInfo()).isIlankoProduct());
        }
        return false;
    }

}

