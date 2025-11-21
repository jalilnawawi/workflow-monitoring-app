package jalilspringproject.workflow_monitoring_app.controller;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.request.ServiceCaseRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.GetServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.ServiceCaseResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_case.response.SummaryServiceCaseByStatusResponse;
import jalilspringproject.workflow_monitoring_app.service.ServiceCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/service-cases")
@CrossOrigin
public class ServiceCaseController {
    @Autowired
    ServiceCaseService serviceCaseService;

    @PostMapping
    public ResponseEntity<DataResponse<ServiceCaseResponseDto>> create(
            @RequestParam Long serviceTypeId,
            @RequestParam Long workflowTemplateId
    ) {
            ServiceCaseRequestDto requestDto = new ServiceCaseRequestDto(
                    serviceTypeId,
                    workflowTemplateId
            );
            DataResponse<ServiceCaseResponseDto> response = serviceCaseService.createServiceCase(requestDto);
            return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<GetServiceCaseResponseDto>>> getAll() {
        DataResponse<List<GetServiceCaseResponseDto>> response = serviceCaseService.getAll();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{serviceCaseId}")
    public ResponseEntity<DataResponse<GetServiceCaseResponseDto>> getById(@PathVariable Long serviceCaseId) {
        DataResponse<GetServiceCaseResponseDto> response = serviceCaseService.getById(serviceCaseId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{serviceCaseId}")
    public ResponseEntity<DataResponse<ServiceCaseResponseDto>> updateServiceCase(
            @PathVariable Long serviceCaseId,
            @RequestParam Long serviceTypeId,
            @RequestParam Long workflowTemplateId
    ) {
        ServiceCaseRequestDto requestDto = new ServiceCaseRequestDto(
                serviceTypeId,
                workflowTemplateId
        );
        DataResponse<ServiceCaseResponseDto> response = serviceCaseService.updateServiceCase(serviceCaseId, requestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PatchMapping("/{serviceCaseId}/status")
    public ResponseEntity<DataResponse<ServiceCaseResponseDto>> changeStatus(
            @PathVariable Long serviceCaseId,
            @RequestParam String status
    ) {
        DataResponse<ServiceCaseResponseDto> response = serviceCaseService.changeStatus(serviceCaseId, status);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{serviceCaseId}")
    public ResponseEntity<Void> deleteServiceCase(@PathVariable Long serviceCaseId) {
        serviceCaseService.deleteServiceCase(serviceCaseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/summary-by-status")
    public ResponseEntity<DataResponse<List<SummaryServiceCaseByStatusResponse>>> getSummaryByStatus() {
        DataResponse<List<SummaryServiceCaseByStatusResponse>> response = serviceCaseService.getSummaryByStatus();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
