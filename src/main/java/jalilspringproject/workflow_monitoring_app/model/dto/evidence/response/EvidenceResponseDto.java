package jalilspringproject.workflow_monitoring_app.model.dto.evidence.response;

import jalilspringproject.workflow_monitoring_app.model.entity.Evidence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EvidenceResponseDto {
    private String caseStageName;
    private String fileUrl;
    private String fileName;
    private String fileType;
    private String description;
    private String uploadedByUsername;

    public static EvidenceResponseDto toCreateEvidenceResponseDto(Evidence evidence) {
        EvidenceResponseDto dto = new EvidenceResponseDto();
        dto.setCaseStageName(evidence.getCaseStage().getName());
        dto.setFileUrl(evidence.getFileUrl());
        dto.setFileName(evidence.getFileName());
        dto.setFileType(evidence.getFileType());
        dto.setDescription(evidence.getDescription());
        dto.setUploadedByUsername(evidence.getUploadedBy().getUsername());
        return dto;
    }
}
