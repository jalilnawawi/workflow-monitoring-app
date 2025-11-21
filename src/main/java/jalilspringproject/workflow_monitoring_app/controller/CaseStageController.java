package jalilspringproject.workflow_monitoring_app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request.CaseStageRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.CaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.GetCaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.service.CaseStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/case-stages")
@CrossOrigin
@Tag(name = "Case Stage Controller", description = "Controller untuk monitoring progress dari setiap tahapan dalam sebuah kasus layanan.")
public class CaseStageController {
    @Autowired
    CaseStageService caseStageService;

    @PostMapping
    public ResponseEntity<DataResponse<CaseStageResponseDto>> create(
            @RequestParam Long serviceCaseId,
            @RequestParam Long stageTemplateId,
            @RequestBody CaseStageRequestDto caseStageRequestDto
    ) {
        DataResponse<CaseStageResponseDto> response = caseStageService.createCaseStage(serviceCaseId, stageTemplateId, caseStageRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<GetCaseStageResponseDto>>> getAll() {
        DataResponse<List<GetCaseStageResponseDto>> response = caseStageService.getAll();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<GetCaseStageResponseDto>> getById(@PathVariable Long id) {
        DataResponse<GetCaseStageResponseDto> response = caseStageService.getById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<CaseStageResponseDto>> update(
            @PathVariable Long id,
            @RequestBody CaseStageRequestDto caseStageRequestDto
    ) {
        DataResponse<CaseStageResponseDto> response = caseStageService.updateCaseStage(id, caseStageRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DataResponse<CaseStageResponseDto>> updateCompletedStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        DataResponse<CaseStageResponseDto> response = caseStageService.updateCompletedStatus(id, status);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        caseStageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
