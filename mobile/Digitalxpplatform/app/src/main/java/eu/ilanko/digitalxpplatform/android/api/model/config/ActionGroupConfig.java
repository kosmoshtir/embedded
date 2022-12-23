package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface ActionGroupConfig extends GroupConfig<ActionConfig>
{
    /**
     * Returns a list of GroupConfig or ItemConfig objects.
     *
     * @return
     */
    ActionConfig getChildById(String actionId);
}
