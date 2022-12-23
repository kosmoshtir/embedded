package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import eu.ilanko.digitalxpplatform.android.api.model.config.ItemConfig;
import org.json.JSONException;
import org.json.JSONObject;
public class ItemConfigImpl extends BaseConfigImpl implements ItemConfig {
    protected Map<String, Object> configMap;

    protected String iconIdentifier;

    protected String type;

    private String evaluatorId;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    ItemConfigImpl() {
    }

    ItemConfigImpl(String identifier, String iconIdentifier, String label, String description, String type,
                   String evaluatorId, Map<String, Object> configMap) {
        super(identifier, label, description);
        this.configMap = configMap;
        this.iconIdentifier = iconIdentifier;
        this.type = type;
        this.evaluatorId = evaluatorId;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public String getEvaluator() {
        return evaluatorId;
    }

    @Override
    public Object getParameter(String configProperty) {
        return configMap.get(configProperty);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getIconIdentifier() {
        return iconIdentifier;
    }

    @Override
    public Map<String, Object> getParameters() {
        if (configMap == null) {
            return new HashMap<String, Object>(0);
        }
        return new LinkedHashMap<String, Object>(configMap);
    }

    public JSONObject toJson() {
        JSONObject object = super.toJson();
        try {
            object.putOpt(ConfigConstants.ICON_ID_VALUE, iconIdentifier);
            object.putOpt(ConfigConstants.TYPE_VALUE, type);
            object.putOpt(ConfigConstants.EVALUATOR, evaluatorId);
            if (configMap != null) {
                object.putOpt(ConfigConstants.PARAMS_VALUE, mapToJson(getParameters()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    private JSONObject mapToJson(Map<String, Object> map) throws JSONException {
        JSONObject object = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                object.putOpt(entry.getKey(), mapToJson((Map) entry.getValue()));
            }
            object.putOpt(entry.getKey(), entry.getValue());
        }
        return object;
    }
}

