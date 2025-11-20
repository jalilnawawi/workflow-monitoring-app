package jalilspringproject.workflow_monitoring_app.model.dto.service_type.response;

import jalilspringproject.workflow_monitoring_app.model.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetServiceTypeResponseDto {
    private Long id;
    private String code;
    private String name;
    private String description;

    public static GetServiceTypeResponseDto toResponseDto(ServiceType serviceType) {
        GetServiceTypeResponseDto dto = new GetServiceTypeResponseDto();
        dto.setId(serviceType.getId());
        dto.setCode(serviceType.getCode());
        dto.setName(serviceType.getName());
        dto.setDescription(serviceType.getDescription());
        return dto;
    }
}
