package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.lang.ref.WeakReference;
public class HelperConfig
{
    protected WeakReference<ConfigurationImpl> configurationRef;

    protected WeakReference<StringHelper> HelperStringRef;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    HelperConfig(ConfigurationImpl configuration, StringHelper localHelper)
    {
        configurationRef = new WeakReference<ConfigurationImpl>(configuration);
        HelperStringRef = new WeakReference<StringHelper>(localHelper);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // UTILS
    // ///////////////////////////////////////////////////////////////////////////
    protected ConfigurationImpl getConfiguration()
    {
        if (configurationRef == null) { return null; }
        return configurationRef.get();
    }

    protected boolean hasConfiguration()
    {
        return configurationRef != null && configurationRef.get() != null;
    }

    protected boolean hasEvaluatorHelper()
    {
        return configurationRef != null && configurationRef.get().getEvaluatorHelper() != null;
    }

    protected EvaluatorHelper getEvaluatorHelper()
    {
        if (configurationRef == null) { return null; }
        return configurationRef.get().getEvaluatorHelper();
    }

    protected StringHelper getLocaleHelper()
    {
        if (HelperStringRef == null) { return null; }
        return HelperStringRef.get();
    }

}

