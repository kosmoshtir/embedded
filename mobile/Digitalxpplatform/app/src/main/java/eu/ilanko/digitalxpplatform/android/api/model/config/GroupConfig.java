package eu.ilanko.digitalxpplatform.android.api.model.config;
import java.util.List;
public interface GroupConfig<T> extends ItemConfig
{
    /**
     * Returns a list of GroupConfig or ItemConfig objects.
     *
     * @return
     */
    List<T> getItems();
}

