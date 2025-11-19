package jalilspringproject.workflow_monitoring_app.model.dto.evidence.response;

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

    public static EvidenceResponseDto toCreateEvidenceResponseDto(String caseStageName, String fileUrl, String fileName, String fileType, String description, String uploadedByUsername) {
        EvidenceResponseDto dto = new EvidenceResponseDto();
        dto.setCaseStageName(caseStageName);
        dto.setFileUrl(fileUrl);
        dto.setFileName(fileName);
        dto.setFileType(fileType);
        dto.setDescription(description);
        dto.setUploadedByUsername(uploadedByUsername);
        return dto;
    }
}
