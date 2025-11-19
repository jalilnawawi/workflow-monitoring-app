package jalilspringproject.workflow_monitoring_app.model.dto.evidence.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EvidenceRequestDto {
    private String fileUrl;
    private String fileName;
    private String fileType;
    private String description;
}
