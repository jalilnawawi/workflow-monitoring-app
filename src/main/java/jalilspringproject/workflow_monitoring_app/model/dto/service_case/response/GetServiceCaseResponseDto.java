package jalilspringproject.workflow_monitoring_app.model.dto.service_case.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetServiceCaseResponseDto {
    private Long id;
    private String serviceTypeName;
    private String workflowTemplateName;
    private String usernameStaff;
    private String usernameClient;
    private String status;
    private String trackingCode;
}
