package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request.CaseStageRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.CaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.GetCaseStageResponseDto;

import java.util.List;

public interface CaseStageService {
    DataResponse<CaseStageResponseDto> createCaseStage(Long serviceCaseId, Long stageTemplateId, CaseStageRequestDto caseStageRequestDto);
    DataResponse<List<GetCaseStageResponseDto>> getAll();
    DataResponse<GetCaseStageResponseDto> getById(Long id);
    DataResponse<CaseStageResponseDto> updateCaseStage(Long id, CaseStageRequestDto caseStageRequestDto);
    DataResponse<CaseStageResponseDto> updateCompletedStatus(Long id, String status);
    void deleteById(Long id);
}
