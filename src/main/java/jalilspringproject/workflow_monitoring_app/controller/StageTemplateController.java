package jalilspringproject.workflow_monitoring_app.controller;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.request.StageTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.GetStageTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.StageTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.service.StageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stage-templates")
@CrossOrigin
public class StageTemplateController {
    @Autowired
    private StageTemplateService stageTemplateService;

    @PostMapping
    public ResponseEntity<DataResponse<StageTemplateResponseDto>> createStageTemplate(
            @RequestParam Long workflowTemplateId,
            @RequestBody StageTemplateRequestDto stageTemplateRequestDto
    ){
        DataResponse<StageTemplateResponseDto> response = stageTemplateService.createStageTemplate(workflowTemplateId, stageTemplateRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<GetStageTemplateResponseDto>>> getAllStageTemplates(){
        DataResponse<List<GetStageTemplateResponseDto>> response = stageTemplateService.getAll();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<GetStageTemplateResponseDto>> getStageTemplateById(@PathVariable Long id) {
        DataResponse<GetStageTemplateResponseDto> response = stageTemplateService.getById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<StageTemplateResponseDto>> updateStageTemplate(
            @PathVariable Long id,
            @RequestBody StageTemplateRequestDto stageTemplateRequestDto) {
        DataResponse<StageTemplateResponseDto> response = stageTemplateService.updateStageTemplate(id, stageTemplateRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStageTemplate(@PathVariable Long id) {
        stageTemplateService.deleteStageTemplate(id);
        return ResponseEntity.noContent().build();
    }
}
