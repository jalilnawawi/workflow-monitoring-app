package jalilspringproject.workflow_monitoring_app.model.dto.service_type.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTypeResponseDto {
    private String code;
    private String name;
    private String description;
}
