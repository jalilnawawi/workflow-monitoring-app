package jalilspringproject.workflow_monitoring_app.service;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.user.request.CreateUserRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.user.response.CreateUserResponseDto;

public interface UserService {
    DataResponse<CreateUserResponseDto> createUser(CreateUserRequestDto createUserRequestDto);
}
