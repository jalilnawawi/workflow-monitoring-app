package jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response;

import jalilspringproject.workflow_monitoring_app.model.entity.WorkflowTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowTemplateResponseDto {
    private String serviceTypeName;
    private String name;
    private Boolean active;

    public static WorkflowTemplateResponseDto toResponseDto(WorkflowTemplate workflowTemplate){
        WorkflowTemplateResponseDto dto = new WorkflowTemplateResponseDto();
        dto.setServiceTypeName(workflowTemplate.getServiceType().getName());
        dto.setName(workflowTemplate.getName());
        dto.setActive(workflowTemplate.getActive());
        return dto;
    }
}
