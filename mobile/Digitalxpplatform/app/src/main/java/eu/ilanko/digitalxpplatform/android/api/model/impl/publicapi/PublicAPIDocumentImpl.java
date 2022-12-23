package eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi;
import static eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi.PublicAPIPropertyIds.MIMETYPE;
import static eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi.PublicAPIPropertyIds.SIZEINBYTES;
import static eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi.PublicAPIPropertyIds.VERSIONLABEL;

import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.Document;

import android.os.Parcel;
import android.os.Parcelable;
public class PublicAPIDocumentImpl extends PublicAPINodeImpl implements Document
{
    private static final long serialVersionUID = 1L;

    public PublicAPIDocumentImpl()
    {
    }

    public PublicAPIDocumentImpl(Map<String, Object> json)
    {
        super(PublicAPIBaseTypeIds.DOCUMENT.value(), json);
    }

    @Override
    public long getContentStreamLength()
    {
        return (Long) ((getPropertyValue(SIZEINBYTES) == null) ? (long) -1
                : (getPropertyValue(SIZEINBYTES) instanceof String) ? Long
                .parseLong((String) getPropertyValue(SIZEINBYTES)) : getPropertyValue(SIZEINBYTES));
    }

    @Override
    public String getContentStreamMimeType()
    {
        return getPropertyValue(MIMETYPE);
    }

    @Override
    public String getVersionLabel()
    {
        return getPropertyValue(VERSIONLABEL);
    }

    @Override
    public String getVersionComment()
    {
        return null;
    }

    @Override
    public Boolean isLatestVersion()
    {
        // it can't be true everytime...
        return true;
    }

    // ////////////////////////////////////////////////////
    // INTERNAL
    // ////////////////////////////////////////////////////
    /**
     * Internal method to serialize Folder object.
     */
    public static final Parcelable.Creator<PublicAPIDocumentImpl> CREATOR = new Parcelable.Creator<PublicAPIDocumentImpl>()
    {
        public PublicAPIDocumentImpl createFromParcel(Parcel in)
        {
            return new PublicAPIDocumentImpl(in);
        }

        public PublicAPIDocumentImpl[] newArray(int size)
        {
            return new PublicAPIDocumentImpl[size];
        }
    };

    public PublicAPIDocumentImpl(Parcel o)
    {
        super(o);
    }
}

