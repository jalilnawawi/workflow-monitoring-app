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
public class ServiceTypeResponseDto {
    private String code;
    private String name;
    private String description;

    public static ServiceTypeResponseDto toResponseDto(ServiceType serviceType) {
        ServiceTypeResponseDto responseDto = new ServiceTypeResponseDto();
        responseDto.setCode(serviceType.getCode());
        responseDto.setName(serviceType.getName());
        responseDto.setDescription(serviceType.getDescription());
        return responseDto;
    }
}
