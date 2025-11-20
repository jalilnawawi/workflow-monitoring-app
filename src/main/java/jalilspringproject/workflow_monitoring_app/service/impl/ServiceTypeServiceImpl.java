package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.request.ServiceTypeRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.GetServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.service_type.response.ServiceTypeResponseDto;
import jalilspringproject.workflow_monitoring_app.model.entity.ServiceType;
import jalilspringproject.workflow_monitoring_app.repository.ServiceTypeRepository;
import jalilspringproject.workflow_monitoring_app.service.ServiceTypeService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(ServiceTypeServiceImpl.class);

    @Override
    public DataResponse<ServiceTypeResponseDto> createServiceType(ServiceTypeRequestDto serviceTypeRequestDto) {
        try {
            ServiceType serviceType = new ServiceType();
            serviceType.setCode(serviceTypeRequestDto.getCode());
            serviceType.setName(serviceTypeRequestDto.getName());
            serviceType.setDescription(serviceTypeRequestDto.getDescription());
            ServiceType savedServiceType = serviceTypeRepository.save(serviceType);

            ServiceTypeResponseDto responseDto = ServiceTypeResponseDto.toResponseDto(savedServiceType);

            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    responseDto);

        } catch (Exception e) {
            log.error("Error creating service type: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public DataResponse<List<GetServiceTypeResponseDto>> getAll() {
        try {
            List<ServiceType> serviceTypes = serviceTypeRepository.findAll();
            List<GetServiceTypeResponseDto> responseDtos = serviceTypes.stream()
                    .map(GetServiceTypeResponseDto::toResponseDto)
                    .toList();

            return new DataResponse<>(
                ResponseMessage.DATA_FETCHED,
                "Proses Berhasil",
                loggingHolder.getPath(),
                loggingHolder.getDate(),
                HttpStatus.OK.value(),
                responseDtos
            );

        } catch (Exception e) {
            log.error("Error get all service type: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public DataResponse<GetServiceTypeResponseDto> getById(Long serviceTypeId) {
        try {
            ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId)
                    .orElseThrow(() -> new Exception("Service Type not found with id: " + serviceTypeId));
            GetServiceTypeResponseDto responseDto = GetServiceTypeResponseDto.toResponseDto(serviceType);
            return new DataResponse<>(
                ResponseMessage.DATA_FETCHED,
                "Proses Berhasil",
                loggingHolder.getPath(),
                loggingHolder.getDate(),
                HttpStatus.OK.value(),
                responseDto
            );
        } catch (Exception e) {
            log.error("Error get all service type: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public DataResponse<ServiceTypeResponseDto> updateServiceType(Long serviceTypeId, ServiceTypeRequestDto serviceTypeRequestDto) {
        try {
            ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId)
                    .orElseThrow(() -> new Exception("Service Type not found with id: " + serviceTypeId));

            serviceType.setCode(serviceTypeRequestDto.getCode());
            serviceType.setName(serviceTypeRequestDto.getName());
            serviceType.setDescription(serviceTypeRequestDto.getDescription());
            ServiceType updatedServiceType = serviceTypeRepository.save(serviceType);

            ServiceTypeResponseDto responseDto = ServiceTypeResponseDto.toResponseDto(updatedServiceType);
            return new DataResponse<>(
                    ResponseMessage.DATA_UPDATED,
                    "Proses Berhasil",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.OK.value(),
                    responseDto);
        } catch (Exception e) {
            log.error("Error updating service type: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }

    @Override
    public void deleteServiceType(Long serviceTypeId) {
        try {
            ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId)
                    .orElseThrow(() -> new Exception("Service Type not found with id: " + serviceTypeId));
            serviceTypeRepository.delete(serviceType);
        } catch (Exception e) {
            log.error("Error deleting service type: {}", e.getMessage());
        }
    }
}
