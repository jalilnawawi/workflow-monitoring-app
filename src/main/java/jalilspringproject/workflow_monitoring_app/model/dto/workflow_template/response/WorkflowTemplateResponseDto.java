package jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowTemplateResponseDto {
    private Long serviceTypeId;
    private String name;
    private Boolean active;
}
