package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.request.WorkflowTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.GetWorkflowTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.workflow_template.response.WorkflowTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceType;
import jalilspringproject.workflow_monitoring_app.model.entity.WorkflowTemplate;
import jalilspringproject.workflow_monitoring_app.repository.ServiceTypeRepository;
import jalilspringproject.workflow_monitoring_app.repository.WorkflowTemplateRepository;
import jalilspringproject.workflow_monitoring_app.service.ServiceTypeService;
import jalilspringproject.workflow_monitoring_app.service.WorkflowTemplateService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {
    @Autowired
    private WorkflowTemplateRepository workflowTemplateRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(WorkflowTemplateServiceImpl.class);

    @Override
    public DataResponse<WorkflowTemplateResponseDto> createWorkflowTemplate(Long serviceTypeId, WorkflowTemplateRequestDto workflowTemplateRequestDto) {
        try {
            WorkflowTemplate workflowTemplate = new WorkflowTemplate();
            workflowTemplate.setName(workflowTemplateRequestDto.getName());
            workflowTemplate.setActive(workflowTemplateRequestDto.getActive());

            ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId).orElseThrow(
                    () -> new RuntimeException("Service Type with ID " + serviceTypeId + " not found")
            );
            workflowTemplate.setServiceType(serviceType);
            WorkflowTemplate savedWorkflowTemplate = workflowTemplateRepository.save(workflowTemplate);

            WorkflowTemplateResponseDto responseDto = WorkflowTemplateResponseDto.toResponseDto(savedWorkflowTemplate);
            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    responseDto);

        } catch (Exception e) {
            log.error("Error creating service type: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public DataResponse<List<GetWorkflowTemplateResponseDto>> getAll() {
        try {
              List<WorkflowTemplate> workflowTemplates =workflowTemplateRepository.findAll();
                List<GetWorkflowTemplateResponseDto> responseDtos = workflowTemplates.stream()
                        .map(GetWorkflowTemplateResponseDto::toResponseDto)
                        .toList();

                return new DataResponse<>(
                        ResponseMessage.DATA_FETCHED,
                        "Proses Berhasil",
                        loggingHolder.getPath(),
                        loggingHolder.getDate(),
                        HttpStatus.OK.value(),
                        responseDtos);

        } catch (Exception e) {
            log.error("Error fetching workflow templates: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public DataResponse<GetWorkflowTemplateResponseDto> getById(Long id) {
        try {
            WorkflowTemplate workflowTemplate = workflowTemplateRepository.findById(id).orElseThrow(
                    () -> new Exception("Workflow Template not found with id: " + id)
            );
            GetWorkflowTemplateResponseDto responseDto = GetWorkflowTemplateResponseDto.toResponseDto(workflowTemplate);
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto);

        } catch (Exception e) {
            log.error("Error fetching workflow template with id: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public DataResponse<WorkflowTemplateResponseDto> updateWorkflowTemplate(Long id, WorkflowTemplateRequestDto workflowTemplateRequestDto) {
        try {
            WorkflowTemplate workflowTemplate = workflowTemplateRepository.findById(id).orElseThrow(
                    () -> new Exception("Workflow Template not found with id: " + id)
            );
            workflowTemplate.setName(workflowTemplateRequestDto.getName());
            workflowTemplate.setActive(workflowTemplateRequestDto.getActive());
            WorkflowTemplate updatedWorkflowTemplate = workflowTemplateRepository.save(workflowTemplate);
            WorkflowTemplateResponseDto responseDto = WorkflowTemplateResponseDto.toResponseDto(updatedWorkflowTemplate);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto);
        } catch (Exception e) {
            log.error("Error updating workflow template with id: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public void deleteWorkflowTemplate(Long id) {
        try {
            WorkflowTemplate workflowTemplate = workflowTemplateRepository.findById(id).orElseThrow(
                    () -> new Exception("Workflow Template not found with id: " + id)
            );
            workflowTemplateRepository.delete(workflowTemplate);
        } catch (Exception e) {
            log.error("Error deleting workflow template with id: {}", e.getMessage());
        }
    }
}
