package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.request.WorkflowTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.GetWorkflowTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.WorkflowTemplateResponseDto;

import java.util.List;

public interface WorkflowTemplateService {
    WorkflowTemplateResponseDto createWorkflowTemplate(Long serviceTypeId, WorkflowTemplateRequestDto workflowTemplateRequestDto);
    List<GetWorkflowTemplateResponseDto> getAll();
    GetWorkflowTemplateResponseDto getById(Long id);
    WorkflowTemplateResponseDto updateWorkflowTemplate(Long id, WorkflowTemplateRequestDto workflowTemplateRequestDto);
    void deleteWorkflowTemplate(Long id);
}
