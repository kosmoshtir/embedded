package eu.ilanko.digitalxpplatform.android.api.model.config;

public interface BaseConfig
{
    /**
     * Returns the unique identifier of the item.
     *
     * @return
     */
    String getIdentifier();

    /**
     * Returns the label of the item.
     *
     * @return
     */
    String getLabel();

    /**
     * Returns the description of the item.
     *
     * @return
     */
    String getDescription();
}
