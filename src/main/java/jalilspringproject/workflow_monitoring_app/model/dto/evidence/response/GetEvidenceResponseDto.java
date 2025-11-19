package jalilspringproject.workflow_monitoring_app.model.dto.evidence.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetEvidenceResponseDto {
    private Long id;
    private String caseStageName;
    private String fileUrl;
    private String fileName;
    private String fileType;
    private String description;
    private String uploadedByUsername;
}
