package jalilspringproject.workflow_monitoring_app.controller;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.request.WorkflowTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.GetWorkflowTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.WorkflowTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflow-templates")
public class WorkflowTemplateController {
    @Autowired
    private WorkflowTemplateService workflowTemplateService;

    @PostMapping
    public ResponseEntity<DataResponse<WorkflowTemplateResponseDto>> createWorkflowTemplate(
            @RequestParam Long serviceTypeId,
            @RequestBody WorkflowTemplateRequestDto workflowTemplateRequestDto
    ) {
        DataResponse<WorkflowTemplateResponseDto> response = workflowTemplateService.createWorkflowTemplate(serviceTypeId, workflowTemplateRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<GetWorkflowTemplateResponseDto>>> getAllWorkflowTemplates() {
        DataResponse<List<GetWorkflowTemplateResponseDto>> response = workflowTemplateService.getAll();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<GetWorkflowTemplateResponseDto>> getWorkflowTemplateById(@PathVariable Long id) {
        DataResponse<GetWorkflowTemplateResponseDto> response = workflowTemplateService.getById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<WorkflowTemplateResponseDto>> updateWorkflowTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplateRequestDto workflowTemplateRequestDto
    ) {
        DataResponse<WorkflowTemplateResponseDto> response = workflowTemplateService.updateWorkflowTemplate(id, workflowTemplateRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkflowTemplate(@PathVariable Long id) {
        workflowTemplateService.deleteWorkflowTemplate(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
