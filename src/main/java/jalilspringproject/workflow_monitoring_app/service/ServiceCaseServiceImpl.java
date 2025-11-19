package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.dto.service_case.request.ServiceCaseRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.GetServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.ServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.repository.ServiceCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCaseServiceImpl implements ServiceCaseService {
    @Autowired
    ServiceCaseRepository serviceCaseRepository;

    @Override
    public ServiceCaseResponseDto createServiceCase(ServiceCaseRequestDto serviceCaseRequestDto) {
        return null;
    }

    @Override
    public GetServiceCaseResponseDto getAll() {
        return null;
    }

    @Override
    public GetServiceCaseResponseDto getById(Long serviceCaseId) {
        return null;
    }

    @Override
    public ServiceCaseResponseDto updateServiceCase(Long serviceCaseId, ServiceCaseRequestDto serviceCaseRequestDto) {
        return null;
    }

    @Override
    public ServiceCaseResponseDto changeStatus(Long serviceCaseId, String status) {
        return null;
    }

    @Override
    public void deleteServiceCase(Long serviceCaseId) {

    }
}
