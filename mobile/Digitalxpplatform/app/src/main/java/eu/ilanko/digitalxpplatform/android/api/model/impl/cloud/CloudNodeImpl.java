package eu.ilanko.digitalxpplatform.android.api.model.impl.cloud;
import java.util.Map;

import eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi.PublicAPINodeImpl;

import android.os.Parcel;
import android.os.Parcelable;
public class CloudNodeImpl extends PublicAPINodeImpl
{
    private static final long serialVersionUID = 1L;

    // ////////////////////////////////////////////////////
    // Constructors
    // ////////////////////////////////////////////////////
    public CloudNodeImpl()
    {
    }

    /**
     * Default constructor of a Node based on CMIS service and object.
     *
     * @param o
     */
    public CloudNodeImpl(String type, Map<String, Object> json)
    {
        super(type, json);
    }

    // ////////////////////////////////////////////////////
    // Save State - serialization / deserialization
    // ////////////////////////////////////////////////////
    public static final Parcelable.Creator<CloudNodeImpl> CREATOR = new Parcelable.Creator<CloudNodeImpl>()
    {
        public CloudNodeImpl createFromParcel(Parcel in)
        {
            return new CloudNodeImpl(in);
        }

        public CloudNodeImpl[] newArray(int size)
        {
            return new CloudNodeImpl[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        super.writeToParcel(dest, flags);
    }

    public CloudNodeImpl(Parcel o)
    {
        super(o);
    }
}

