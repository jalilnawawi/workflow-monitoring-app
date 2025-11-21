package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.request.ServiceCaseRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.GetServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.ServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.SummaryServiceCaseByStatusProjection;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.SummaryServiceCaseByStatusResponse;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceCase;
import jalilspringproject.workflow_monitoring_app.model.entity.User;
import jalilspringproject.workflow_monitoring_app.model.enums.CaseStatus;
import jalilspringproject.workflow_monitoring_app.repository.ServiceCaseRepository;
import jalilspringproject.workflow_monitoring_app.repository.ServiceTypeRepository;
import jalilspringproject.workflow_monitoring_app.repository.UserRepository;
import jalilspringproject.workflow_monitoring_app.repository.WorkflowTemplateRepository;
import jalilspringproject.workflow_monitoring_app.service.ServiceCaseService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceCaseServiceImpl implements ServiceCaseService {
    @Autowired
    ServiceCaseRepository serviceCaseRepository;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    WorkflowTemplateRepository workflowTemplateRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(EvidenceServiceImpl.class);

    @Override
    public DataResponse<ServiceCaseResponseDto> createServiceCase(ServiceCaseRequestDto requestDto) {
        try {
            ServiceCase serviceCase = new ServiceCase();
            serviceCase.setServiceType(serviceTypeRepository.findById(requestDto.getServiceTypeId()).orElseThrow(
                    () -> new RuntimeException("Service Type not found")
            ));
            serviceCase.setWorkflowTemplate(workflowTemplateRepository.findById(requestDto.getWorkflowTemplateId()).orElseThrow(
                    () -> new RuntimeException("Workflow Template not found")
            ));

            User user = userRepository.findById(UUID.fromString("a802aa3c-78a5-4e53-b95e-38fe0bf7ce0e")).orElseThrow(
                    () -> new RuntimeException("User not found")
            );

            serviceCase.setUser(user);
            serviceCase.setUsername(user.getUsername());
            serviceCase.setStatus(CaseStatus.PENDING);

            String dateNow = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String randomString = UUID.randomUUID().toString();
            String trackingCode = "ORDER-" + dateNow + "-" + randomString.substring(0, 5);
            serviceCase.setTrackingCode(trackingCode);

            ServiceCase saved = serviceCaseRepository.save(serviceCase);
            ServiceCaseResponseDto responseDto = ServiceCaseResponseDto.toServiceCaseResponseDto(saved);
            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when create service case: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<List<GetServiceCaseResponseDto>> getAll() {
        try {
            List<ServiceCase> serviceCaseList = serviceCaseRepository.findAll();
            List<GetServiceCaseResponseDto> responseDtoList = serviceCaseList.stream()
                    .map(GetServiceCaseResponseDto::toResponseDto)
                    .toList();
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDtoList
            );
        } catch (Exception e) {
            log.error("Error when get all service case: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<GetServiceCaseResponseDto> getById(Long serviceCaseId) {
        try {
            ServiceCase serviceCase = serviceCaseRepository.findById(serviceCaseId).orElseThrow(
                    () -> new RuntimeException("Service Case not found")
            );
            GetServiceCaseResponseDto responseDto = GetServiceCaseResponseDto.toResponseDto(serviceCase);
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when get service case by id: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<ServiceCaseResponseDto> updateServiceCase(Long serviceCaseId, ServiceCaseRequestDto serviceCaseRequestDto) {
        try {
            ServiceCase serviceCase = serviceCaseRepository.findById(serviceCaseId).orElseThrow(
                    () -> new RuntimeException("Service Case not found")
            );
            serviceCase.setServiceType(serviceTypeRepository.findById(serviceCaseRequestDto.getServiceTypeId()).orElseThrow(
                    () -> new RuntimeException("Service Type not found")
            ));
            serviceCase.setWorkflowTemplate(workflowTemplateRepository.findById(serviceCaseRequestDto.getWorkflowTemplateId()).orElseThrow(
                    () -> new RuntimeException("Workflow Template not found")
            ));
            // Note: User and username update logic is omitted for brevity
            ServiceCase updated = serviceCaseRepository.save(serviceCase);
            ServiceCaseResponseDto responseDto = ServiceCaseResponseDto.toServiceCaseResponseDto(updated);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when update service case: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public DataResponse<ServiceCaseResponseDto> changeStatus(Long serviceCaseId, String status) {
        try {
            ServiceCase serviceCase = serviceCaseRepository.findById(serviceCaseId).orElseThrow(
                    () -> new RuntimeException("Service Case not found")
            );
            serviceCase.setStatus(CaseStatus.valueOf(status));
            ServiceCase updated = serviceCaseRepository.save(serviceCase);
            ServiceCaseResponseDto responseDto = ServiceCaseResponseDto.toServiceCaseResponseDto(updated);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto
            );
        } catch (Exception e) {
            log.error("Error when change service case status: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }

    @Override
    public void deleteServiceCase(Long serviceCaseId) {
        try {
            serviceCaseRepository.deleteById(serviceCaseId);
        } catch (Exception e) {
            log.error("Error when delete service case: {}", e.getMessage(), e);
        }
    }

    @Override
    public DataResponse<List<SummaryServiceCaseByStatusResponse>> getSummaryByStatus() {
        try {
            List<SummaryServiceCaseByStatusProjection> summaryProjections = serviceCaseRepository.getSummaryByStatus();
            List<SummaryServiceCaseByStatusResponse> responseList = summaryProjections.stream()
                    .map(SummaryServiceCaseByStatusResponse::fromProjection)
                    .toList();
            return new DataResponse<>(
                    ResponseMessage.DATA_FETCHED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseList
            );
        } catch (Exception e) {
            log.error("Error when get summary by status: {}", e.getMessage(), e);
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
        }
    }
}
