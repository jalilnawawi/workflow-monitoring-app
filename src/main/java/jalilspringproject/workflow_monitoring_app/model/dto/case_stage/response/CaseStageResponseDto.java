package jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response;

import jalilspringproject.workflow_monitoring_app.model.entity.CaseStage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CaseStageResponseDto {
    private Long serviceCaseId;
    private String stageTemplateName;
    private String name;
    private Integer orderIndex;
    private String status;
    private String notes;

    public static CaseStageResponseDto toCaseStageResponseDto(CaseStage caseStage){
        CaseStageResponseDto dto = new CaseStageResponseDto();
        dto.setServiceCaseId(caseStage.getServiceCase().getId());
        dto.setStageTemplateName(caseStage.getStageTemplate().getName());
        dto.setName(caseStage.getName());
        dto.setOrderIndex(caseStage.getOrderIndex());
        dto.setStatus(caseStage.getStatus().name());
        dto.setNotes(caseStage.getNotes());
        return dto;
    }
}
