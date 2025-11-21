package jalilspringproject.workflow_monitoring_app.model.dto.service_case.response;

import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrackingCodeDto {
    private String trackingCode;
    private String workflow;
    private String tahapan;
    private String status;
}
