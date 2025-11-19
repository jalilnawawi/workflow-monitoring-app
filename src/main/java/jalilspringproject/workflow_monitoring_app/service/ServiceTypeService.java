package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.service_type.request.ServiceTypeRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.GetServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.ServiceTypeResponseDto;

public interface ServiceTypeService {
    ServiceTypeResponseDto createServiceType(ServiceTypeRequestDto serviceTypeRequestDto);
    GetServiceTypeResponseDto getAll();
    GetServiceTypeResponseDto getById(Long serviceTypeId);
    ServiceTypeResponseDto updateServiceType(Long serviceTypeId, ServiceTypeRequestDto serviceTypeRequestDto);
    void deleteServiceType(Long serviceTypeId);
}
