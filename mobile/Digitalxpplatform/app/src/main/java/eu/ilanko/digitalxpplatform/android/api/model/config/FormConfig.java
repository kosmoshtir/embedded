package eu.ilanko.digitalxpplatform.android.api.model.config;
import java.util.List;
public interface FormConfig extends ItemConfig
{
    /**
     * Returns the layout the client application should use to render the form.
     */
    public String getLayout();

    /** Returns the groups for the form. */
    public List<FieldGroupConfig> getGroups();
}
