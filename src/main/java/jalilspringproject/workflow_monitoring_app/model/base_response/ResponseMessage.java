package jalilspringproject.workflow_monitoring_app.model.base_response;

import lombok.Getter;

@Getter
public final class ResponseMessage {
    public static final String DATA_CREATED = "Data successfully created.";
    public static final String DATA_UPDATED = "Data successfully modified.";
    public static final String DATA_FETCHED = "Data(s) successfully fetched.";
    public static final String DATA_DELETED = "Data successfully deleted.";
    public static final String DATA_NOT_FOUND = "Data not found.";
    public static final String DATA_ALREADY_EXISTS = "Data already exists.";
    public static final String MISSING_PARAMETER = "Some required parameter(s) are missing for this request.";
    public static final String DATA_INVALID = "Some of parameter(s) are invalid.";
    public static final String FORBIDDEN = "Data access is forbidden.";
    public static final String EMPTY_DATA = "No data found matching the search criteria.";
    public static final String MSG_INTERNAL_SERVER_ERROR = "Gagal mengambil data karena kesalahan internal.";
}
