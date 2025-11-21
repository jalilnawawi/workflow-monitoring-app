package jalilspringproject.workflow_monitoring_app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.request.EvidenceRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.EvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.evidence.response.GetEvidenceResponseDto;
import jalilspringproject.workflow_monitoring_app.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/evidences")
@CrossOrigin
@Tag(name = "Evidence Controller", description = "Controller untuk mengelola dokumen atau berkas yang perlu dikumpulkan")
public class EvidenceController {
    @Autowired
    private EvidenceService evidenceService;

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DataResponse<EvidenceResponseDto>> createEvidence(
            @RequestParam Long caseStageId,
            // Ubah @RequestPart DTO menjadi String
            @RequestPart(value = "data", required = false) String requestDtoStr,
            @RequestPart("file") MultipartFile file
    ) throws IOException {

        // Konversi Manual String JSON ke Object
        EvidenceRequestDto requestDto = new EvidenceRequestDto();
        if (requestDtoStr != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                requestDto = mapper.readValue(requestDtoStr, EvidenceRequestDto.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Format JSON salah");
            }
        }

        DataResponse<EvidenceResponseDto> response = evidenceService.createEvidence(caseStageId, requestDto, file);
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
