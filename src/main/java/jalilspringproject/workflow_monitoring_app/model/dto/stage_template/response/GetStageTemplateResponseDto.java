package jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetStageTemplateResponseDto {
    private Long id;
    private String workflowName;
    private String name;
    private String description;
    private Integer orderIndex;
    private Boolean requiresEvidence;
    private String evidenceType;
    private String evidenceInstruction;
}
