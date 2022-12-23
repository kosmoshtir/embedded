package eu.ilanko.digitalxpplatform.android.api.model.config;
import java.util.List;

public interface CreationConfig
{
    /** Returns the list of mimetypes the application should allow creation of. */
    List<ItemConfig> getCreatableMimeTypes();

    /**
     * Returns the list of content types the application should allow creation
     * of.
     */
    List<ItemConfig> getCreatableDocumentTypes();

    /**
     * Returns the list of folder types the application should allow creation
     * of.
     */
    List<ItemConfig> getCreatableFolderTypes();

}
