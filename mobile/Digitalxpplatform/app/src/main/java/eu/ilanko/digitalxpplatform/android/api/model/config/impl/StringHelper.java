package eu.ilanko.digitalxpplatform.android.api.model.config.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import eu.ilanko.digitalxpplatform.android.api.model.config.ConfigConstants;

import android.util.Log;
public class StringHelper
{
    private static final String TAG = StringHelper.class.getSimpleName();

    private Properties properties;

    // ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    // ///////////////////////////////////////////////////////////////////////////
    public static StringHelper load(File file)
    {
        if (!file.exists()) { return null; }

        StringHelper config = null;
        try
        {
            config = load(new FileInputStream(file));
        }
        catch (Exception e)
        {
            Log.w(TAG, Log.getStackTraceString(e));
        }
        return config;
    }

    public static StringHelper load(InputStream inputStream)
    {
        StringHelper config = null;
        try
        {
            Properties properties = new Properties();
            properties.load(inputStream);
            config = new StringHelper(properties);
        }
        catch (Exception e)
        {
            Log.w(TAG, Log.getStackTraceString(e));
        }
        return config;
    }

    private StringHelper(Properties properties)
    {
        this.properties = properties;
    }

    // ///////////////////////////////////////////////////////////////////////////
    // UTILITIES
    // ///////////////////////////////////////////////////////////////////////////
    public static String getLocalizedFileName()
    {
        String filename = ConfigConstants.CONFIG_LOCALIZATION_FILENAME;
        if (!Locale.ENGLISH.equals(Locale.getDefault().getLanguage()))
        {
            filename = String.format(ConfigConstants.CONFIG_LOCALIZATION_FILENAME_PATTERN, Locale.getDefault()
                    .getLanguage());
        }
        return filename;
    }

    public static String getDefaultLocalizedFileName()
    {
        return ConfigConstants.CONFIG_LOCALIZATION_FILENAME;
    }

    public static String getRepositoryLocalizedFilePath()
    {
        return ConfigConstants.CONFIG_LOCALIZATION_FOLDER_PATH.concat(getLocalizedFileName());
    }

    public static String getDefaultRepositoryLocalizedFilePath()
    {
        return ConfigConstants.CONFIG_LOCALIZATION_FOLDER_PATH.concat(ConfigConstants.CONFIG_LOCALIZATION_FILENAME);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////////////////
    public String getString(String key)
    {
        String value = key;
        if (properties == null) { return key; }
        value = properties.getProperty(key);
        return (value == null) ? key : value;
    }
}

