package jalilspringproject.workflow_monitoring_app.controller;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.request.ServiceTypeRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.GetServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.ServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/service-types")
public class ServiceTypeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping
    public ResponseEntity<DataResponse<ServiceTypeResponseDto>> createServiceType(@RequestBody ServiceTypeRequestDto serviceTypeRequestDto){
        DataResponse<ServiceTypeResponseDto> response = serviceTypeService.createServiceType(serviceTypeRequestDto);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<GetServiceTypeResponseDto>>> getAll(){
        DataResponse<List<GetServiceTypeResponseDto>> response = serviceTypeService.getAll();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<GetServiceTypeResponseDto>> getServiceType(@PathVariable("id") Long id){
        DataResponse<GetServiceTypeResponseDto> response = serviceTypeService.getById(id);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<ServiceTypeResponseDto>> updateServiceType(
            @PathVariable("id") Long id,
            @RequestBody ServiceTypeRequestDto serviceTypeRequestDto){
        DataResponse<ServiceTypeResponseDto> response = serviceTypeService.updateServiceType(id, serviceTypeRequestDto);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<ServiceTypeResponseDto>> deleteServiceType(@PathVariable("id") Long id){
        serviceTypeService.deleteServiceType(id);
        return ResponseEntity.noContent().build();
    }
}
