package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import eu.ilanko.digitalxpplatform.android.api.model.config.ValidationConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class ValidationHelper extends HelperConfig
{
    private LinkedHashMap<String, ValidationConfig> validationConfigIndex;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ValidationHelper(ConfigurationImpl context, StringHelper localHelper)
    {
        super(context, localHelper);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // INIT
    // ///////////////////////////////////////////////////////////////////////////
    void addValidation(Map<String, Object> validations)
    {
        validationConfigIndex = new LinkedHashMap<>(validations.size());
        ValidationConfigData data = null;
        for (Entry<String, Object> entry : validations.entrySet())
        {
            data = new ValidationConfigData(entry.getKey(), JSONConverter.getMap(entry.getValue()), getConfiguration());
            validationConfigIndex.put(data.identifier, new ValidationConfigImpl(data.identifier, data.iconIdentifier,
                    data.label, data.description, data.type, data.properties, data.errorId));
        }
    }

    // ///////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public ValidationConfig getValidationRuleById(String id)
    {
        if (validationConfigIndex == null || validationConfigIndex.isEmpty()) { return null; }
        return validationConfigIndex.get(id);
    }

}
