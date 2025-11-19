package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.request.StageTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.GetStageTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.StageTemplateResponseDto;

public interface StageTemplateService {
    StageTemplateResponseDto createStageTemplate(StageTemplateRequestDto stageTemplateRequestDto);
    GetStageTemplateResponseDto getAll();
    GetStageTemplateResponseDto getById(Long id);
    StageTemplateResponseDto updateStageTemplate(Long id, StageTemplateRequestDto stageTemplateRequestDto);
    void deleteStageTemplate(Long id);
}
