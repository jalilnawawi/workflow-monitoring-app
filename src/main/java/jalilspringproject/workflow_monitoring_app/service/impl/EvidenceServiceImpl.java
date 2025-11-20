package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.GetEvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.entity.CaseStage;
import jalilspringproject.workflow_monitoring_app.model.entity.Evidence;
import jalilspringproject.workflow_monitoring_app.repository.CaseStageRepository;
import jalilspringproject.workflow_monitoring_app.repository.EvidenceRepository;
import jalilspringproject.workflow_monitoring_app.service.EvidenceService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    @Autowired
    private EvidenceRepository evidenceRepository;

    @Autowired
    private CaseStageRepository caseStageRepository;

    @Autowired
    private LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(ServiceTypeServiceImpl.class);

    @Override
    public DataResponse<EvidenceResponseDto> createEvidence(Long caseStageId, EvidenceRequestDto evidenceRequestDto) {
        try {
            Evidence evidence = new Evidence();
            evidence.setFileName(evidenceRequestDto.getFileName());
            evidence.setFileUrl(evidenceRequestDto.getFileUrl());
            evidence.setFileType(evidenceRequestDto.getFileType());
            evidence.setDescription(evidenceRequestDto.getDescription());

            CaseStage caseStage = caseStageRepository.findById(caseStageId).orElseThrow(
                    () -> new RuntimeException("CaseStage with ID " + caseStageId + " not found")
            );
            evidence.setCaseStage(caseStage);
            evidence.setUploadedBy(null); // Set uploadedBy appropriately
            Evidence saved = evidenceRepository.save(evidence);

            EvidenceResponseDto responseDto = EvidenceResponseDto.toCreateEvidenceResponseDto(saved);
            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    responseDto
            );

        } catch (Exception e) {
            log.error("Error creating evidence: {}", e.getMessage());
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
    public DataResponse<List<GetEvidenceResponseDto>> getAllEvidence() {
        try {
            List<Evidence> evidences = evidenceRepository.findAll();
            List<GetEvidenceResponseDto> responseDtos = evidences.stream()
                    .map(GetEvidenceResponseDto::toGetEvidenceResponseDto)
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
            log.error("Error retrieving all evidence: {}", e.getMessage());
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
    public DataResponse<GetEvidenceResponseDto> getEvidenceById(Long id) {
        try {
            Evidence evidence = evidenceRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Evidence with ID " + id + " not found")
            );
            GetEvidenceResponseDto responseDto = GetEvidenceResponseDto.toGetEvidenceResponseDto(evidence);

            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );

        } catch (Exception e) {
            log.error("Error retrieving evidence by ID: {}", e.getMessage());
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
    public DataResponse<EvidenceResponseDto> updateEvidence(Long id, EvidenceRequestDto evidenceRequestDto) {
        try {
            Evidence evidence = evidenceRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Evidence with ID " + id + " not found")
            );
            evidence.setFileName(evidenceRequestDto.getFileName());
            evidence.setFileUrl(evidenceRequestDto.getFileUrl());
            evidence.setFileType(evidenceRequestDto.getFileType());
            evidence.setDescription(evidenceRequestDto.getDescription());
            Evidence updated = evidenceRepository.save(evidence);
            EvidenceResponseDto responseDto = EvidenceResponseDto.toCreateEvidenceResponseDto(updated);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error updating evidence: {}", e.getMessage());
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
    public void deleteEvidence(Long id) {
        try {
            Evidence evidence = evidenceRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Evidence with ID " + id + " not found")
            );
            evidenceRepository.delete(evidence);
        } catch (Exception e) {
            log.error("Error deleting evidence: {}", e.getMessage());
            throw new RuntimeException("Proses Gagal: " + e.getMessage());
        }
    }
}
