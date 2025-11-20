package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.request.ServiceCaseRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.GetServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.ServiceCaseResponseDto;

import java.util.List;

public interface ServiceCaseService {
    DataResponse<ServiceCaseResponseDto> createServiceCase(ServiceCaseRequestDto requestDto);
    DataResponse<List<GetServiceCaseResponseDto>> getAll();
    DataResponse<GetServiceCaseResponseDto> getById(Long serviceCaseId);
    DataResponse<ServiceCaseResponseDto> updateServiceCase(Long serviceCaseId, ServiceCaseRequestDto serviceCaseRequestDto);
    DataResponse<ServiceCaseResponseDto> changeStatus(Long serviceCaseId, String status);
    void deleteServiceCase(Long serviceCaseId);
}
