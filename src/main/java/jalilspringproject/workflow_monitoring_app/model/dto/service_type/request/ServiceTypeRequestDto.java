package jalilspringproject.workflow_monitoring_app.model.dto.service_type.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTypeRequestDto {
    private String code;
    private String name;
    private String description;
}
