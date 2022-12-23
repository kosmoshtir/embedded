package eu.ilanko.digitalxpplatform.android.api.model.impl.publicapi;
import eu.ilanko.digitalxpplatform.android.api.constants.PublicAPIConstant;
public final class PublicAPIPropertyIds
{
    private PublicAPIPropertyIds() {
    }

    // ---- base ----
    public static final String TYPE = PublicAPIConstant.TYPE_VALUE;
    public static final String NAME = PublicAPIConstant.NAME_VALUE;
    public static final String ID = PublicAPIConstant.ID_VALUE;
    public static final String GUID = PublicAPIConstant.GUID_VALUE;
    public static final String TITLE = PublicAPIConstant.TITLE_VALUE;
    public static final String DESCRIPTION = PublicAPIConstant.DESCRIPTION_VALUE;
    public static final String CREATEDBY = PublicAPIConstant.CREATEDBY_VALUE;
    public static final String CREATEDAT = PublicAPIConstant.CREATEDAT_VALUE;
    public static final String MODIFIEDBY = PublicAPIConstant.MODIFIEDBY_VALUE;
    public static final String MODIFIEDAT = PublicAPIConstant.MODIFIEDAT_VALUE;

    // ---- document ----
    public static final String VERSIONLABEL = PublicAPIConstant.VERSIONLABEL_VALUE;
    public static final String SIZEINBYTES = PublicAPIConstant.SIZEINBYTES_VALUE;
    public static final String MIMETYPE = PublicAPIConstant.MIMETYPE_VALUE;

    // ---- extra ----
    public static final String REQUEST_STATUS = "request_status";
    public static final String REQUEST_TYPE = "request_type";

}
