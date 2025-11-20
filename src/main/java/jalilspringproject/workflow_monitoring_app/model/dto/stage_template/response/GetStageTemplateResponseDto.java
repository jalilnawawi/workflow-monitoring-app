package jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response;

import jalilspringproject.workflow_monitoring_app.model.entity.StageTemplate;
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

    public static GetStageTemplateResponseDto fromEntity(StageTemplate stageTemplate){
        GetStageTemplateResponseDto dto = new GetStageTemplateResponseDto();
        dto.setId(stageTemplate.getId());
        dto.setWorkflowName(stageTemplate.getWorkflowTemplate().getName());
        dto.setName(stageTemplate.getName());
        dto.setDescription(stageTemplate.getDescription());
        dto.setOrderIndex(stageTemplate.getOrderIndex());
        dto.setRequiresEvidence(stageTemplate.getRequiredEvidence());
        dto.setEvidenceType(stageTemplate.getEvidenceType().name());
        dto.setEvidenceInstruction(stageTemplate.getEvidenceInstruction());
        return dto;
    }
}
