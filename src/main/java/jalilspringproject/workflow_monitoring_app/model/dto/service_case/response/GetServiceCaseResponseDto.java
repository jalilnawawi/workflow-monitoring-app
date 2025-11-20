package jalilspringproject.workflow_monitoring_app.model.dto.service_case.response;

import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.GetServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceType;
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

    public static GetServiceCaseResponseDto toResponseDto(ServiceCase serviceCase){
        GetServiceCaseResponseDto dto = new GetServiceCaseResponseDto();
        dto.setId(serviceCase.getId());
        dto.setServiceTypeName(serviceCase.getServiceType().getName());
        dto.setWorkflowTemplateName(serviceCase.getWorkflowTemplate().getName());
        dto.setUsernameStaff(serviceCase.getUser().getUsername());
        dto.setUsernameClient(serviceCase.getUser().getUsername());
        dto.setStatus(serviceCase.getStatus().name());
        dto.setTrackingCode(serviceCase.getTrackingCode());
        return dto;
    }
}
