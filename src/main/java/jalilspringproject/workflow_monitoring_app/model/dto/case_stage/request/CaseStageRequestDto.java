package jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request;

import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import jalilspringproject.workflow_monitoring_app.model.entity.StageTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CaseStageRequestDto {
    private String name;
    private Integer orderIndex;
    private String status;
    private String notes;
}
