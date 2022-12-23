package eu.ilanko.digitalxpplatform.android.api.model.impl.cloud;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi.PublicAPIDocumentImpl;

import android.os.Parcel;
import android.os.Parcelable;
public class CloudDocumentImpl extends PublicAPIDocumentImpl
{
    private static final long serialVersionUID = 1L;

    public CloudDocumentImpl()
    {
    }

    public CloudDocumentImpl(Map<String, Object> json)
    {
        super(json);
    }

    // ////////////////////////////////////////////////////
    // INTERNAL
    // ////////////////////////////////////////////////////
    /**
     * Internal method to serialize Folder object.
     */
    public static final Parcelable.Creator<CloudDocumentImpl> CREATOR = new Parcelable.Creator<CloudDocumentImpl>()
    {
        public CloudDocumentImpl createFromParcel(Parcel in)
        {
            return new CloudDocumentImpl(in);
        }

        public CloudDocumentImpl[] newArray(int size)
        {
            return new CloudDocumentImpl[size];
        }
    };

    public CloudDocumentImpl(Parcel o)
    {
        super(o);
    }
}

