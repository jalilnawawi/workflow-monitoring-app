package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.service_case.request.ServiceCaseRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.GetServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.ServiceCaseResponseDto;

public interface ServiceCaseService {
    ServiceCaseResponseDto createServiceCase(Long serviceTypeId, ServiceCaseRequestDto serviceCaseRequestDto);
    GetServiceCaseResponseDto getAll();
    GetServiceCaseResponseDto getById(Long serviceCaseId);
    ServiceCaseResponseDto updateServiceCase(Long serviceCaseId, ServiceCaseRequestDto serviceCaseRequestDto);
    ServiceCaseResponseDto changeStatus(Long serviceCaseId, String status);
    void deleteServiceCase(Long serviceCaseId);
}
