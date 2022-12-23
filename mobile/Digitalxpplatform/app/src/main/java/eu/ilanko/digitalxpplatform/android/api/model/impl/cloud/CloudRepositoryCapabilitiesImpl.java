package eu.ilanko.digitalxpplatform.android.api.model.impl.cloud;
import eu.ilanko.digitalxpplatform.android.api.model.impl.AbstractRepositoryCapabilities;
public class CloudRepositoryCapabilitiesImpl extends AbstractRepositoryCapabilities
{
    private static final long serialVersionUID = 1L;

    /**
     * In cloud context, like and comment count are by default enable.
     */
    public CloudRepositoryCapabilitiesImpl()
    {
        capabilities.put(CAPABILITY_LIKE, true);
        capabilities.put(CAPABILITY_COMMENTS_COUNT, true);
    }

    @Override
    public boolean doesSupportPublicAPI()
    {
        return true;
    }

    @Override
    public boolean doesSupportActivitiWorkflowEngine()
    {
        return true;
    }

    @Override
    public boolean doesSupportJBPMWorkflowEngine()
    {
        return false;
    }

    @Override
    public boolean doesSupportMyFiles()
    {
        return false;
    }

    @Override
    public boolean doesSupportSharedFiles()
    {
        return false;
    }
}

