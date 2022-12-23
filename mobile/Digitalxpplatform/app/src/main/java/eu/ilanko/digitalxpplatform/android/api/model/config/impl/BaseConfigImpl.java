package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import eu.ilanko.digitalxpplatform.android.api.model.config.BaseConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import org.json.JSONException;
import org.json.JSONObject;
public class BaseConfigImpl implements BaseConfig
{
    protected String identifier;

    protected String label;

    protected String description;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    BaseConfigImpl()
    {
    }

    BaseConfigImpl(String identifier, String label, String description)
    {
        super();
        this.identifier = identifier;
        this.label = label;
        this.description = description;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getIdentifier()
    {
        return identifier;
    }

    @Override
    public String getLabel()
    {
        return label;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    public JSONObject toJson()
    {
        JSONObject object = new JSONObject();
        try
        {
            object.putOpt(ConfigConstants.ID_VALUE, identifier);
            object.putOpt(ConfigConstants.LABEL_ID_VALUE, label);
            object.putOpt(ConfigConstants.DESCRIPTION_ID_VALUE, description);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return object;
    }
}

