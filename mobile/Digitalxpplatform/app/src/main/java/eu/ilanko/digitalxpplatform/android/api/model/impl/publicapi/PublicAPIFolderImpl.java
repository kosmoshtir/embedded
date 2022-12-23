package eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.Folder;

import android.os.Parcel;
import android.os.Parcelable;

public class PublicAPIFolderImpl extends PublicAPINodeImpl implements Folder
{

    private static final long serialVersionUID = 1L;

    public PublicAPIFolderImpl()
    {
    }

    public PublicAPIFolderImpl(Map<String, Object> json)
    {
        super(PublicAPIBaseTypeIds.FOLDER.value(), json);
    }

    // ////////////////////////////////////////////////////
    // INTERNAL
    // ////////////////////////////////////////////////////

    /**
     * Internal method to serialize Folder object.
     */
    public static final Parcelable.Creator<PublicAPIFolderImpl> CREATOR = new Parcelable.Creator<PublicAPIFolderImpl>()
    {
        public PublicAPIFolderImpl createFromParcel(Parcel in)
        {
            return new PublicAPIFolderImpl(in);
        }

        public PublicAPIFolderImpl[] newArray(int size)
        {
            return new PublicAPIFolderImpl[size];
        }
    };

    public PublicAPIFolderImpl(Parcel o)
    {
        super(o);
    }
}

