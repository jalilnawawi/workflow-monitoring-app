package jalilspringproject.workflow_monitoring_app.model.dto.service_case.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SummaryServiceCaseByStatusResponse {
    private String status;
    private Integer count;

    public static SummaryServiceCaseByStatusResponse fromProjection(jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.SummaryServiceCaseByStatusProjection projection) {
        SummaryServiceCaseByStatusResponse response = new SummaryServiceCaseByStatusResponse();
        response.setStatus(projection.getStatus());
        response.setCount(projection.getCount());
        return response;
    }
}
