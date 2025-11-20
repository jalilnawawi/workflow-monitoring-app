package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.request.WorkflowTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.GetWorkflowTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.WorkflowTemplateResponseDto;

import java.util.List;

public interface WorkflowTemplateService {
    DataResponse<WorkflowTemplateResponseDto> createWorkflowTemplate(Long serviceTypeId, WorkflowTemplateRequestDto workflowTemplateRequestDto);
    DataResponse<List<GetWorkflowTemplateResponseDto>> getAll();
    DataResponse<GetWorkflowTemplateResponseDto> getById(Long id);
    DataResponse<WorkflowTemplateResponseDto> updateWorkflowTemplate(Long id, WorkflowTemplateRequestDto workflowTemplateRequestDto);
    void deleteWorkflowTemplate(Long id);
}
