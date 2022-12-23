package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.ArrayList;
import java.util.List;

import eu.ilanko.digitalxpplatform.android.api.model.config.FeatureConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class FeatureHelper extends HelperConfig
{
    private ArrayList<FeatureConfig> featureConfigs;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    FeatureHelper(ConfigurationImpl context, StringHelper localHelper)
    {
        super(context, localHelper);
    }

    boolean addFeatureConfig(List<Object> features)
    {
        if (features == null || features.isEmpty()) { return false; }
        featureConfigs = new ArrayList<>(features.size());
        FeatureConfig featureConfig = null;
        for (Object featureData : features)
        {
            featureConfig = FeatureConfigImpl.parse(JSONConverter.getMap(featureData), getConfiguration());
            featureConfigs.add(featureConfig);
        }
        return true;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public List<FeatureConfig> getFeatures()
    {
        if (featureConfigs == null) { return new ArrayList<>(); }
        return featureConfigs;
    }
}

