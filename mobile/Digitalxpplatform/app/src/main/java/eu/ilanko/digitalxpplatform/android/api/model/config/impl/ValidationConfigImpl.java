package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ValidationConfig;
public class ValidationConfigImpl extends ItemConfigImpl implements ValidationConfig
{
    private String errorMessage;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ValidationConfigImpl(String identifier, String label, String type, String evaluatorId)
    {
        super(identifier, null, label, null, type, null, null);
    }

    ValidationConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                         Map<String, Object> properties, String errorId)
    {
        super(identifier, iconIdentifier, label, description, type, null, properties);
        this.errorMessage = errorId;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getErrorMessage()
    {
        return errorMessage;
    }
}

