package jalilspringproject.workflow_monitoring_app.model.base_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataResponse<T> {
    String result;
    String detail;
    String path;
    String date;
    int statusCode;
    T data;
}
