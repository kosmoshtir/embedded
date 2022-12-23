package eu.ilanko.digitalxpplatform.android.api.model.impl.cloud;

import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi.PublicAPIFolderImpl;

import android.os.Parcel;
import android.os.Parcelable;
public class CloudFolderImpl extends PublicAPIFolderImpl
{

    private static final long serialVersionUID = 1L;

    public CloudFolderImpl()
    {
    }

    public CloudFolderImpl(Map<String, Object> json)
    {
        super(json);
    }

    // ////////////////////////////////////////////////////
    // INTERNAL
    // ////////////////////////////////////////////////////

    /**
     * Internal method to serialize Folder object.
     */
    public static final Parcelable.Creator<CloudFolderImpl> CREATOR = new Parcelable.Creator<CloudFolderImpl>()
    {
        public CloudFolderImpl createFromParcel(Parcel in)
        {
            return new CloudFolderImpl(in);
        }

        public CloudFolderImpl[] newArray(int size)
        {
            return new CloudFolderImpl[size];
        }
    };

    public CloudFolderImpl(Parcel o)
    {
        super(o);
    }
}

