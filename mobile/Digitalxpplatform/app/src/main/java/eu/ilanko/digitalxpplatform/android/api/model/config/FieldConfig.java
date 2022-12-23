package eu.ilanko.digitalxpplatform.android.api.model.config;
import java.util.List;
public interface FieldConfig extends ItemConfig
{
    /** Returns the property/association name associated to the field. */
    String getModelIdentifier();

    /**     Returns the list ValidationConfig objects representing the validation rules for the field.*/
    List<ValidationConfig> getValidationRules();
}

