package jalilspringproject.workflow_monitoring_app.model.dto.stage_template.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StageTemplateRequestDto {
    private String name;
    private String description;
    private Integer orderIndex;
    private Boolean requiresEvidence;
    private String evidenceType;
    private String evidenceInstruction;
}
