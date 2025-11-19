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
public class ServiceCaseResponseDto {
    private String serviceTypeName;
    private String workflowTemplateName;
    private String usernameStaff;
    private String usernameClient;
    private String status;
    private String trackingCode;

    public static ServiceCaseResponseDto toServiceCaseResponseDto(ServiceCase serviceCase){
        ServiceCaseResponseDto dto = new ServiceCaseResponseDto();
        dto.setServiceTypeName(serviceCase.getServiceType().getName());
        dto.setWorkflowTemplateName(serviceCase.getWorkflowTemplate().getName());
        dto.setUsernameStaff(serviceCase.getUser().getUsername());
        dto.setUsernameClient(serviceCase.getUser().getUsername());
        dto.setStatus(serviceCase.getStatus().name());
        dto.setTrackingCode(serviceCase.getTrackingCode());
        return dto;
    }
}
