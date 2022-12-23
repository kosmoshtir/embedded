package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface FeatureConfig extends ItemConfig
{
    // ///////////////////////////////////////////////////////////////////////////
    // DEFAULT FEATURE
    // ///////////////////////////////////////////////////////////////////////////
    String PREFIX_FEATURE = "eu.ilanko.client.feature";

    // If ON ==> user can define the value
    // If OFF ==> analytics is OFF
    String FEATURE_ANALYTICS = PREFIX_FEATURE.concat(".analytics");

    // If ON ==> data protection is activated and cant be changed
    // If OFF ==> user can define the value
    // If ON then OFF ==> protection is still active but can be deactivated by
    // the user.
    String FEATURE_DATA_PROTECTION = PREFIX_FEATURE.concat(".data.protection");

    // If ON ==> passcode is activated by default and cant be changed
    // If OFF ==> user can define the value
    // If ON then OFF ==> passcode is still active but can be deactivated by the
    // user.
    String FEATURE_PASSCODE = PREFIX_FEATURE.concat(".passcode");

    // If ON ==> user can define the value
    // If OFF ==> cellular sync is OFF / Sync only on Wifi and cant be changed
    // If OFF then ON ==> cellular sync is still OFF but can be reactivated by
    // the user.
    String FEATURE_CELLULAR_SYNC = PREFIX_FEATURE.concat(".sync.cellular");

    // If ON ==> user can define the value
    // If OFF ==> cellular sync is OFF / Sync only on Wifi and cant be changed
    // If OFF then ON ==> cellular sync is still OFF but can be reactivated by
    // the user.
    String FEATURE_SCHEDULER_SYNC = PREFIX_FEATURE.concat(".sync.scheduler");

    boolean isEnable();
}

