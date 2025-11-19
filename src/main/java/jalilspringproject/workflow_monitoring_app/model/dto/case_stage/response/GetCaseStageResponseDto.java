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
public class GetCaseStageResponseDto {
    private Long id;
    private Long serviceCaseId;
    private String stageTemplateName;
    private String name;
    private Integer orderIndex;
    private String status;
    private String notes;

    public static GetCaseStageResponseDto toCaseStageResponseDto(CaseStage caseStage){
        GetCaseStageResponseDto dto = new GetCaseStageResponseDto();
        dto.setId(caseStage.getId());
        dto.setServiceCaseId(caseStage.getServiceCase().getId());
        dto.setStageTemplateName(caseStage.getStageTemplate().getName());
        dto.setName(caseStage.getName());
        dto.setOrderIndex(caseStage.getOrderIndex());
        dto.setStatus(caseStage.getStatus().name());
        dto.setNotes(caseStage.getNotes());
        return dto;
    }
}
