package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.GetEvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.service.EvidenceService;
import org.springframework.stereotype.Service;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    @Override
    public EvidenceResponseDto createEvidence(Long caseStageId, EvidenceRequestDto evidenceRequestDto) {
        return null;
    }

    @Override
    public GetEvidenceResponseDto getAllEvidence() {
        return null;
    }

    @Override
    public GetEvidenceResponseDto getEvidenceById(Long id) {
        return null;
    }

    @Override
    public EvidenceResponseDto updateEvidence(Long id, EvidenceRequestDto evidenceRequestDto) {
        return null;
    }

    @Override
    public void deleteEvidence(Long id) {

    }
}
