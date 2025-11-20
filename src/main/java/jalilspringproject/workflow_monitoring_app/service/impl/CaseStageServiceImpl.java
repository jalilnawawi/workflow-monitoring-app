package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request.CaseStageRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.CaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.GetCaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.entity.CaseStage;
import jalilspringproject.workflow_monitoring_app.model.entity.Evidence;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import jalilspringproject.workflow_monitoring_app.model.entity.StageTemplate;
import jalilspringproject.workflow_monitoring_app.model.enums.CaseStatus;
import jalilspringproject.workflow_monitoring_app.model.enums.StageStatus;
import jalilspringproject.workflow_monitoring_app.repository.CaseStageRepository;
import jalilspringproject.workflow_monitoring_app.repository.ServiceCaseRepository;
import jalilspringproject.workflow_monitoring_app.repository.StageTemplateRepository;
import jalilspringproject.workflow_monitoring_app.service.CaseStageService;
import jalilspringproject.workflow_monitoring_app.service.EvidenceService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CaseStageServiceImpl implements CaseStageService {
    @Autowired
    CaseStageRepository caseStageRepository;

    @Autowired
    ServiceCaseRepository serviceCaseRepository;

    @Autowired
    StageTemplateRepository stageTemplateRepository;

    @Autowired
    EvidenceService evidenceService;

    @Autowired
    LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(EvidenceServiceImpl.class);

    @Override
    public DataResponse<CaseStageResponseDto> createCaseStage(Long serviceCaseId, Long stageTemplateId, CaseStageRequestDto caseStageRequestDto) {
        try {
            CaseStage caseStage = new CaseStage();
            ServiceCase serviceCase = serviceCaseRepository.findById(serviceCaseId).orElseThrow(
                    () -> new RuntimeException("Service Case not found")
            );

            caseStage.setServiceCase(serviceCase);

            StageTemplate stageTemplate = stageTemplateRepository.findById(stageTemplateId).orElseThrow(
                    () -> new RuntimeException("Stage Template not found")
            );
            caseStage.setStageTemplate(stageTemplate);
            caseStage.setName(caseStageRequestDto.getName());
            caseStage.setOrderIndex(caseStageRequestDto.getOrderIndex());
            caseStage.setStatus(StageStatus.valueOf(caseStageRequestDto.getStatus()));
            caseStage.setStartedAt(LocalDateTime.now());
            caseStage.setNotes(caseStageRequestDto.getNotes());
            CaseStage saved = caseStageRepository.save(caseStage);

            CaseStageResponseDto responseDto = CaseStageResponseDto.toCaseStageResponseDto(saved);
            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when create case stage: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<List<GetCaseStageResponseDto>> getAll() {
        try {
            List<CaseStage> caseStages = caseStageRepository.findAll();
            List<GetCaseStageResponseDto> responseDtos = caseStages.stream()
                    .map(GetCaseStageResponseDto::toCaseStageResponseDto)
                    .toList();
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDtos
            );
        } catch (Exception e) {
            log.error("Error when get all case stages: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<GetCaseStageResponseDto> getById(Long id) {
        try {
            CaseStage caseStage = caseStageRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Case Stage not found")
            );
            GetCaseStageResponseDto responseDto = GetCaseStageResponseDto.toCaseStageResponseDto(caseStage);
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when get case stage by id: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<CaseStageResponseDto> updateCaseStage(Long id, CaseStageRequestDto caseStageRequestDto) {
        try {
            CaseStage caseStage = caseStageRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Case Stage not found")
            );
            caseStage.setName(caseStageRequestDto.getName());
            caseStage.setOrderIndex(caseStageRequestDto.getOrderIndex());
            caseStage.setStatus(StageStatus.valueOf(caseStageRequestDto.getStatus()));
            caseStage.setNotes(caseStageRequestDto.getNotes());
            CaseStage updated = caseStageRepository.save(caseStage);
            CaseStageResponseDto responseDto = CaseStageResponseDto.toCaseStageResponseDto(updated);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when update case stage: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<CaseStageResponseDto> updateCompletedStatus(Long id, String status) {
        try {
            CaseStage caseStage = caseStageRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Case Stage not found")
            );
            if (CaseStatus.valueOf(status).equals(CaseStatus.COMPLETED)) {
                caseStage.setStatus(StageStatus.COMPLETED);
                caseStage.setCompletedAt(LocalDateTime.now());
                CaseStage updated = caseStageRepository.save(caseStage);
                CaseStageResponseDto responseDto = CaseStageResponseDto.toCaseStageResponseDto(updated);
                return new DataResponse<>(
                        ResponseMessage.DATA_UPDATED,
                        "Proses Berhasil",
                        loggingHolder.getPath(),
                        loggingHolder.getDate(),
                        HttpStatus.OK.value(),
                        responseDto
                );
            } else {
                return new DataResponse<>(
                        ResponseMessage.MISSING_PARAMETER,
                        "Status tidak valid untuk pembaruan tahap kasus",
                        loggingHolder.getPath(),
                        loggingHolder.getDate(),
                        HttpStatus.BAD_REQUEST.value(),
                        null
                );
            }
        } catch (Exception e) {
            log.error("Error when update case stage status: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            caseStageRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error when delete case stage by id: {}", e.getMessage(), e);
        }
    }
}
