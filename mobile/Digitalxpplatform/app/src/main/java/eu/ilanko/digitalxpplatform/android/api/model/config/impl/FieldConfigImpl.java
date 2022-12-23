package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.FieldConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.ValidationConfig;
public class FieldConfigImpl extends ItemConfigImpl implements FieldConfig
{
    protected String modelIdentifier;

    private List<ValidationConfig> validationRules;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    FieldConfigImpl(String identifier, String label, String type, String evaluatorId)
    {
        super(identifier, null, label, null, type, evaluatorId, null);
    }

    FieldConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                    Map<String, Object> properties, ArrayList<String> forms, String evaluatorId, String modelIdentifier,
                    List<ValidationConfig> validationRules)
    {
        super(identifier, iconIdentifier, label, description, type, evaluatorId, properties);
        this.modelIdentifier = modelIdentifier;
        this.validationRules = validationRules;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getModelIdentifier()
    {
        return modelIdentifier;
    }

    @Override
    public List<ValidationConfig> getValidationRules()
    {
        if (validationRules == null) return new ArrayList<ValidationConfig>(0);
        return validationRules;
    }
}

