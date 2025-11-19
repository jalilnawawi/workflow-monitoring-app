package jalilspringproject.workflow_monitoring_app.model.dto.service_case.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCaseRequestDto {
    private Long serviceTypeId;
    private Long workflowTemplateId;
    private String usernameClient;
}
