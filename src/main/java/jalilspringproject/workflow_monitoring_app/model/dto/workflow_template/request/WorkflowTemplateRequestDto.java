package jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowTemplateRequestDto {
    private String name;
    private Boolean active;
}
