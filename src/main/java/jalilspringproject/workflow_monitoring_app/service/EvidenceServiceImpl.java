package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import org.springframework.stereotype.Service;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    @Override
    public EvidenceResponseDto createEvidence(EvidenceRequestDto evidenceRequestDto) {
        return null;
    }
}
