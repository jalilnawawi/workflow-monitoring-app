package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.GetEvidenceResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EvidenceService {
    DataResponse<EvidenceResponseDto> createEvidence(Long caseStageId, EvidenceRequestDto evidenceRequestDto, MultipartFile file) throws IOException;
    DataResponse<List<GetEvidenceResponseDto>> getAllEvidence();
    DataResponse<GetEvidenceResponseDto> getEvidenceById(Long id);
    DataResponse<EvidenceResponseDto> updateEvidence(Long id, EvidenceRequestDto evidenceRequestDto);
    void deleteEvidence(Long id);
}
