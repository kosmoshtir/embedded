package eu.ilanko.digitalxpplatform.android.api.model.config.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;
import eu.ilanko.digitalxpplatform.android.api.model.config.CreationConfig;
import eu.ilanko.digitalxpplatform.android.api.model.config.ItemConfig;
import org.apache.chemistry.opencmis.commons.impl.JSONConverter;
public class CreationConfigImpl implements CreationConfig
{

    protected List<ItemConfig> creatableMimetypes = new ArrayList<ItemConfig>(0);

    protected List<ItemConfig> creatableDocumentTypes = new ArrayList<ItemConfig>(0);

    protected List<ItemConfig> creatableFolderTypes = new ArrayList<ItemConfig>(0);

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    CreationConfigImpl()
    {
    }

    static CreationConfig parse(Map<String, Object> json, ConfigurationImpl configuration)
    {
        CreationConfigImpl creationConfig = new CreationConfigImpl();

        if (json.containsKey(ConfigConstants.MIME_TYPES_VALUE))
        {
            creationConfig.creatableMimetypes = retrieveListItemConfig(
                    JSONConverter.getList(json.get(ConfigConstants.MIME_TYPES_VALUE)), configuration);
        }

        if (json.containsKey(ConfigConstants.DOCUMENT_TYPES_VALUE))
        {
            creationConfig.creatableDocumentTypes = retrieveListItemConfig(
                    JSONConverter.getList(json.get(ConfigConstants.DOCUMENT_TYPES_VALUE)), configuration);
        }

        if (json.containsKey(ConfigConstants.FOLDER_TYPES_VALUE))
        {
            creationConfig.creatableFolderTypes = retrieveListItemConfig(
                    JSONConverter.getList(json.get(ConfigConstants.FOLDER_TYPES_VALUE)), configuration);
        }

        return creationConfig;
    }

    private static List<ItemConfig> retrieveListItemConfig(List<Object> list, ConfigurationImpl configuration)
    {
        List<ItemConfig> listItems = new ArrayList<ItemConfig>(list.size());
        Map<String, Object> json;
        for (Object object : list)
        {
            json = JSONConverter.getMap(object);
            ItemConfigData data = new ItemConfigData(null, json, configuration);

            listItems.add(new ItemConfigImpl(data.identifier, data.iconIdentifier, data.label, data.description, data.type, data.evaluatorId, data.properties));
        }
        return listItems;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // METHODS
    // ///////////////////////////////////////////////////////////////////////////
    @Override
    public List<ItemConfig> getCreatableMimeTypes()
    {
        return creatableMimetypes;
    }

    @Override
    public List<ItemConfig> getCreatableDocumentTypes()
    {
        return creatableDocumentTypes;
    }

    @Override
    public List<ItemConfig> getCreatableFolderTypes()
    {
        return creatableFolderTypes;
    }

}

