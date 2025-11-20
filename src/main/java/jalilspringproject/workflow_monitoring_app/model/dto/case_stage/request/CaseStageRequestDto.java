package jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
