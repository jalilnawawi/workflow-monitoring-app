package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.request.StageTemplateRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.GetStageTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.stage_template.response.StageTemplateResponseDto;
import jalilspringproject.workflow_monitoring_app.model.entity.StageTemplate;
import jalilspringproject.workflow_monitoring_app.model.enums.EvidenceType;
import jalilspringproject.workflow_monitoring_app.repository.StageTemplateRepository;
import jalilspringproject.workflow_monitoring_app.service.StageTemplateService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageTemplateServiceImpl implements StageTemplateService {
    @Autowired
    private StageTemplateRepository stageTemplateRepository;

    @Autowired
    private LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(ServiceTypeServiceImpl.class);

    @Override
    public DataResponse<StageTemplateResponseDto> createStageTemplate(StageTemplateRequestDto stageTemplateRequestDto) {
        try {
            StageTemplate stageTemplate = new StageTemplate();
            stageTemplate.setName(stageTemplateRequestDto.getName());
            stageTemplate.setDescription(stageTemplateRequestDto.getDescription());
            stageTemplate.setOrderIndex(stageTemplateRequestDto.getOrderIndex());
            stageTemplate.setRequiredEvidence(stageTemplateRequestDto.getRequiresEvidence());
            stageTemplate.setEvidenceInstruction(stageTemplateRequestDto.getEvidenceInstruction());
            switch (stageTemplateRequestDto.getEvidenceType()) {
                case "PDF":
                    stageTemplate.setEvidenceType(EvidenceType.PDF);
                    break;
                case "IMAGE":
                    stageTemplate.setEvidenceType(EvidenceType.IMAGE);
                    break;
                case "ANY":
                    stageTemplate.setEvidenceType(EvidenceType.ANY);
                    break;
                default:
                    return new DataResponse<>(
                            ResponseMessage.MISSING_PARAMETER,
                            "Invalid evidence type specified",
                            loggingHolder.getPath(),
                            loggingHolder.getDate(),
                            HttpStatus.BAD_REQUEST.value(),
                            null);
            }

            StageTemplate savedStageTemplate = stageTemplateRepository.save(stageTemplate);
            StageTemplateResponseDto responseDto = StageTemplateResponseDto.fromEntity(savedStageTemplate);
            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Stage template created successfully",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    responseDto
            );

        } catch (Exception e) {
            log.error("Error when creating stage template: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Failed to create stage template",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<List<GetStageTemplateResponseDto>> getAll() {
        try {
            List<StageTemplate> stageTemplates = stageTemplateRepository.findAll();
            List<GetStageTemplateResponseDto> responseDtos = stageTemplates.stream()
                    .map(GetStageTemplateResponseDto::fromEntity)
                    .toList();
            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Stage templates retrieved successfully",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDtos
            );
        } catch (Exception e) {
            log.error("Error when getting all stage templates: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Failed to retrieve stage templates",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    500,
                    null
            );
        }
    }

    @Override
    public DataResponse<GetStageTemplateResponseDto> getById(Long id) {
        try {
            StageTemplate stageTemplate = stageTemplateRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Stage template not found")
            );

            GetStageTemplateResponseDto responseDto = GetStageTemplateResponseDto.fromEntity(stageTemplate);
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Stage template retrieved successfully",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when getting stage template by id: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Failed to retrieve stage template",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    500,
                    null
            );
        }
    }

    @Override
    public DataResponse<StageTemplateResponseDto> updateStageTemplate(Long id, StageTemplateRequestDto stageTemplateRequestDto) {
        try {
            StageTemplate stageTemplate = stageTemplateRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Stage template not found")
            );
            stageTemplate.setName(stageTemplateRequestDto.getName());
            stageTemplate.setDescription(stageTemplateRequestDto.getDescription());
            stageTemplate.setOrderIndex(stageTemplateRequestDto.getOrderIndex());
            stageTemplate.setRequiredEvidence(stageTemplateRequestDto.getRequiresEvidence());
            stageTemplate.setEvidenceInstruction(stageTemplateRequestDto.getEvidenceInstruction());
            switch (stageTemplateRequestDto.getEvidenceType()) {
                case "PDF":
                    stageTemplate.setEvidenceType(EvidenceType.PDF);
                    break;
                case "IMAGE":
                    stageTemplate.setEvidenceType(EvidenceType.IMAGE);
                    break;
                case "ANY":
                    stageTemplate.setEvidenceType(EvidenceType.ANY);
                    break;
                default:
                    return new DataResponse<>(
                            ResponseMessage.MISSING_PARAMETER,
                            "Invalid evidence type specified",
                            loggingHolder.getPath(),
                            loggingHolder.getDate(),
                            HttpStatus.BAD_REQUEST.value(),
                            null);
            }
            StageTemplate updatedStageTemplate = stageTemplateRepository.save(stageTemplate);
            StageTemplateResponseDto responseDto = StageTemplateResponseDto.fromEntity(updatedStageTemplate);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Stage template updated successfully",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );

        } catch (Exception e) {
            log.error("Error when updating stage template: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Failed to update stage template",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public void deleteStageTemplate(Long id) {
        try {
          StageTemplate stageTemplate = stageTemplateRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Stage template not found")
            );
          stageTemplateRepository.delete(stageTemplate);
        } catch (Exception e) {
            log.error("Error when deleting stage template: {}", e.getMessage(), e);
        }
    }
}
