package jalilspringproject.workflow_monitoring_app.model.dto.evidence.request;

import jalilspringproject.workflow_monitoring_app.model.entity.CaseStage;
import jalilspringproject.workflow_monitoring_app.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EvidenceRequestDto {
    private CaseStage caseStage;
    private String fileUrl;
    private String fileName;
    private String fileType;
    private String description;
    private User uploadedBy;
}
