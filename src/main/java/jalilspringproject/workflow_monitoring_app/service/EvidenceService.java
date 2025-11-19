package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.GetEvidenceResponseDto;

public interface EvidenceService {
    EvidenceResponseDto createEvidence(EvidenceRequestDto evidenceRequestDto);
    GetEvidenceResponseDto getAllEvidence();
    GetEvidenceResponseDto getEvidenceById(Long id);
    EvidenceResponseDto updateEvidence(Long id, EvidenceRequestDto evidenceRequestDto);
    void deleteEvidence(Long id);
}
