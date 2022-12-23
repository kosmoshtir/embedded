package eu.ilanko.digitalxpplatform.android.api.model.config.impl.constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.chemistry.opencmis.commons.PropertyIds;
public class ModelMappingUtils
{
    /** ILANKO OpenCMIS extension prefix for all aspects. */
    public static final String CMISPREFIX_ASPECTS = "P:";

    public static final String CMISPREFIX_DOCUMENT = "D:";

    public static final String CMISPREFIX_FOLDER = "F:";

    /** All CMIS properties identifier in one list. */
    public static final Set<String> CMISMODEL_KEYS = new HashSet<String>();
    static
    {
        CMISMODEL_KEYS.add(PropertyIds.NAME);
        CMISMODEL_KEYS.add(PropertyIds.OBJECT_ID);
        CMISMODEL_KEYS.add(PropertyIds.OBJECT_TYPE_ID);
        CMISMODEL_KEYS.add(PropertyIds.BASE_TYPE_ID);
        CMISMODEL_KEYS.add(PropertyIds.CREATED_BY);
        CMISMODEL_KEYS.add(PropertyIds.CREATION_DATE);
        CMISMODEL_KEYS.add(PropertyIds.LAST_MODIFIED_BY);
        CMISMODEL_KEYS.add(PropertyIds.LAST_MODIFICATION_DATE);
        CMISMODEL_KEYS.add(PropertyIds.CHANGE_TOKEN);
        CMISMODEL_KEYS.add(PropertyIds.IS_IMMUTABLE);
        CMISMODEL_KEYS.add(PropertyIds.IS_LATEST_VERSION);
        CMISMODEL_KEYS.add(PropertyIds.IS_MAJOR_VERSION);
        CMISMODEL_KEYS.add(PropertyIds.IS_LATEST_MAJOR_VERSION);
        CMISMODEL_KEYS.add(PropertyIds.VERSION_LABEL);
        CMISMODEL_KEYS.add(PropertyIds.VERSION_SERIES_ID);
        CMISMODEL_KEYS.add(PropertyIds.IS_VERSION_SERIES_CHECKED_OUT);
        CMISMODEL_KEYS.add(PropertyIds.VERSION_SERIES_CHECKED_OUT_BY);
        CMISMODEL_KEYS.add(PropertyIds.VERSION_SERIES_CHECKED_OUT_ID);
        CMISMODEL_KEYS.add(PropertyIds.CHECKIN_COMMENT);
        CMISMODEL_KEYS.add(PropertyIds.CONTENT_STREAM_LENGTH);
        CMISMODEL_KEYS.add(PropertyIds.CONTENT_STREAM_MIME_TYPE);
        CMISMODEL_KEYS.add(PropertyIds.CONTENT_STREAM_FILE_NAME);
        CMISMODEL_KEYS.add(PropertyIds.CONTENT_STREAM_ID);
        CMISMODEL_KEYS.add(PropertyIds.PARENT_ID);
        CMISMODEL_KEYS.add(PropertyIds.ALLOWED_CHILD_OBJECT_TYPE_IDS);
        CMISMODEL_KEYS.add(PropertyIds.SOURCE_ID);
        CMISMODEL_KEYS.add(PropertyIds.TARGET_ID);
        CMISMODEL_KEYS.add(PropertyIds.POLICY_TEXT);
    }

    /**
     * List of Properties Mapping CMIS to ILANKO
     */
    public static final Map<String, String> ILANKO_TO_CMIS = new HashMap<String, String>();
    static
    {
        ILANKO_TO_CMIS.put(ContentModel.PROP_NAME, PropertyIds.NAME);
        ILANKO_TO_CMIS.put(ContentModel.PROP_CREATED, PropertyIds.CREATION_DATE);
        ILANKO_TO_CMIS.put(ContentModel.PROP_CREATOR, PropertyIds.CREATED_BY);
        ILANKO_TO_CMIS.put(ContentModel.PROP_MODIFIED, PropertyIds.LAST_MODIFICATION_DATE);
        ILANKO_TO_CMIS.put(ContentModel.PROP_MODIFIER, PropertyIds.LAST_MODIFIED_BY);
        ILANKO_TO_CMIS.put(ContentModel.PROP_VERSION_LABEL, PropertyIds.VERSION_LABEL);
        ILANKO_TO_CMIS.put(ContentModel.PROP_SIZE, PropertyIds.CONTENT_STREAM_LENGTH);
        ILANKO_TO_CMIS.put(ContentModel.PROP_MIMETYPE, PropertyIds.CONTENT_STREAM_MIME_TYPE);
        ILANKO_TO_CMIS.put(ContentModel.PROP_PATH, PropertyIds.PATH);
    }

    /**
     * List of Properties Mapping ILANKO to CMIS
     */
    public static final Map<String, String> CMIS_TO_ILANKO = new HashMap<String, String>();
    static
    {
        CMIS_TO_ILANKO.put(PropertyIds.NAME, ContentModel.PROP_NAME);
        CMIS_TO_ILANKO.put(PropertyIds.CREATION_DATE, ContentModel.PROP_CREATED);
        CMIS_TO_ILANKO.put(PropertyIds.CREATED_BY, ContentModel.PROP_CREATOR);
        CMIS_TO_ILANKO.put(PropertyIds.LAST_MODIFICATION_DATE, ContentModel.PROP_MODIFIED);
        CMIS_TO_ILANKO.put(PropertyIds.LAST_MODIFIED_BY, ContentModel.PROP_MODIFIER);
        CMIS_TO_ILANKO.put(PropertyIds.VERSION_LABEL, ContentModel.PROP_VERSION_LABEL);
        CMIS_TO_ILANKO.put(PropertyIds.CONTENT_STREAM_LENGTH, ContentModel.PROP_SIZE);
        CMIS_TO_ILANKO.put(PropertyIds.CONTENT_STREAM_MIME_TYPE, ContentModel.PROP_MIMETYPE);
        CMIS_TO_ILANKO.put(PropertyIds.PATH, ContentModel.PROP_PATH);
    }

    /**
     * List of all aspect that are currently supported by SDK services.
     */
    public static final Map<String, String> ILANKO_ASPECTS = new HashMap<String, String>();
    static
    {

        // TITLE
        ILANKO_ASPECTS.put(ContentModel.PROP_TITLE, CMISPREFIX_ASPECTS + ContentModel.ASPECT_TITLED);
        ILANKO_ASPECTS.put(ContentModel.PROP_DESCRIPTION, CMISPREFIX_ASPECTS + ContentModel.ASPECT_TITLED);

        // TAGS
        ILANKO_ASPECTS.put(ContentModel.PROP_TAGS, CMISPREFIX_ASPECTS + ContentModel.ASPECT_TAGGABLE);

        // GEOGRAPHIC
        for (String prop : ContentModel.ASPECT_GEOGRAPHIC_PROPS)
        {
            ILANKO_ASPECTS.put(prop, CMISPREFIX_ASPECTS + ContentModel.ASPECT_GEOGRAPHIC);
        }

        // EXIF
        for (String prop : ContentModel.ASPECT_EXIF_PROPS)
        {
            ILANKO_ASPECTS.put(prop, CMISPREFIX_ASPECTS + ContentModel.ASPECT_EXIF);
        }

        // AUDIO
        for (String prop : ContentModel.ASPECT_AUDIO_PROPS)
        {
            ILANKO_ASPECTS.put(prop, CMISPREFIX_ASPECTS + ContentModel.ASPECT_AUDIO);
        }

        // AUTHOR
        ILANKO_ASPECTS.put(ContentModel.PROP_AUTHOR, CMISPREFIX_ASPECTS + ContentModel.ASPECT_AUTHOR);

        // RESTRICTABLE
        for (String prop : ContentModel.ASPECT_RESTRICTABLE_PROPS)
        {
            ILANKO_ASPECTS.put(prop, CMISPREFIX_ASPECTS + ContentModel.ASPECT_RESTRICTABLE);
        }
    }

    // ////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////
    private ModelMappingUtils()
    {
    }

    // ////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////
    /**
     * Return the equivalent CMIS property name for a specific ILANKO property
     * name.
     *
     * @param name name of the property.
     * @return the same if equivalent doesn't exist.
     */
    public static String getPropertyName(String name)
    {
        String tmpName = name;
        if (ILANKO_TO_CMIS.containsKey(tmpName))
        {
            tmpName = ILANKO_TO_CMIS.get(tmpName);
        }
        return tmpName;
    }

    /**
     * Return the equivalent ILANKO property name for a specific CMIS property
     * name.
     *
     * @param name name of the property.
     * @return the same if equivalent doesn't exist.
     */
    public static String getIlankoPropertyName(String name)
    {
        String tmpName = name;
        if (CMIS_TO_ILANKO.containsKey(tmpName))
        {
            tmpName = CMIS_TO_ILANKO.get(tmpName);
        }
        return tmpName;
    }

}

