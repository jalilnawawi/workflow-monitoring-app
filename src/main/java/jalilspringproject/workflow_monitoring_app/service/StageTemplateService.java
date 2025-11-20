package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.request.StageTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.GetStageTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.StageTemplateResponseDto;

import java.util.List;

public interface StageTemplateService {
    DataResponse<StageTemplateResponseDto> createStageTemplate(StageTemplateRequestDto stageTemplateRequestDto);
    DataResponse<List<GetStageTemplateResponseDto>> getAll();
    DataResponse<GetStageTemplateResponseDto> getById(Long id);
    DataResponse<StageTemplateResponseDto> updateStageTemplate(Long id, StageTemplateRequestDto stageTemplateRequestDto);
    void deleteStageTemplate(Long id);
}
