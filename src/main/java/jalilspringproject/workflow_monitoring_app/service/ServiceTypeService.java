package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.request.ServiceTypeRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.GetServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.ServiceTypeResponseDto;

import java.util.List;

public interface ServiceTypeService {
    DataResponse<ServiceTypeResponseDto> createServiceType(ServiceTypeRequestDto serviceTypeRequestDto);
    DataResponse<List<GetServiceTypeResponseDto>> getAll();
    DataResponse<GetServiceTypeResponseDto> getById(Long serviceTypeId);
    DataResponse<ServiceTypeResponseDto> updateServiceType(Long serviceTypeId, ServiceTypeRequestDto serviceTypeRequestDto);
    void deleteServiceType(Long serviceTypeId);
}
