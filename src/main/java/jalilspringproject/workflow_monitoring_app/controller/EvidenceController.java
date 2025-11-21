package jalilspringproject.workflow_monitoring_app.controller;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.GetEvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/evidences")
@CrossOrigin
public class EvidenceController {
    @Autowired
    private EvidenceService evidenceService;

    @PostMapping
    public ResponseEntity<DataResponse<EvidenceResponseDto>> createEvidence(
            @RequestParam Long caseStageId,
            @RequestBody EvidenceRequestDto requestDto
    ) {
        DataResponse<EvidenceResponseDto> response = evidenceService.createEvidence(caseStageId, requestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<GetEvidenceResponseDto>>> getAllEvidences(){
        DataResponse<List<GetEvidenceResponseDto>> response = evidenceService.getAllEvidence();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<GetEvidenceResponseDto>> getEvidenceById(@PathVariable Long id) {
        DataResponse<GetEvidenceResponseDto> response = evidenceService.getEvidenceById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<EvidenceResponseDto>> updateEvidence(
            @PathVariable Long id,
            @RequestBody EvidenceRequestDto requestDto
    ) {
        DataResponse<EvidenceResponseDto> response = evidenceService.updateEvidence(id, requestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvidence(@PathVariable Long id) {
        evidenceService.deleteEvidence(id);
        return ResponseEntity.noContent().build();
    }
}
