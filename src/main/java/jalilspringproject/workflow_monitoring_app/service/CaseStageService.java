package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request.CaseStageRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.CaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.GetCaseStageResponseDto;

public interface CaseStageService {
    CaseStageResponseDto createCaseStage(CaseStageRequestDto caseStageRequestDto);
    GetCaseStageResponseDto getAll();
    GetCaseStageResponseDto getById(Long id);
    CaseStageResponseDto updateCaseStage(Long id, CaseStageRequestDto caseStageRequestDto);
    void deleteById(Long id);
}
