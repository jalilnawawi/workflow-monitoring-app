package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.base_response.ResponseMessage;
import jalilspringproject.workflow_monitoring_app.model.dto.user.request.CreateUserRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.user.response.CreateUserResponseDto;
import jalilspringproject.workflow_monitoring_app.model.entity.User;
import jalilspringproject.workflow_monitoring_app.model.enums.UserRole;
import jalilspringproject.workflow_monitoring_app.repository.UserRepository;
import jalilspringproject.workflow_monitoring_app.service.UserService;
import jalilspringproject.workflow_monitoring_app.util.interceptor.LoggingHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public DataResponse<CreateUserResponseDto> createUser(CreateUserRequestDto createUserRequestDto) {
        try {
            User user = new User();
            user.setUsername(createUserRequestDto.getUsername());
            user.setPassword(createUserRequestDto.getPassword());
            user.setName(createUserRequestDto.getName());

            switch (createUserRequestDto.getRole()) {
                case "ADMIN":
                    user.setRole(UserRole.ADMIN);
                    break;
                case "STAFF":
                    user.setRole(UserRole.STAFF);
                    break;
                case "CLIENT":
                    user.setRole(UserRole.CLIENT);
                    break;
                default:
                    return new DataResponse<>(
                            ResponseMessage.MISSING_PARAMETER,
                            "Invalid role specified",
                            loggingHolder.getPath(),
                            loggingHolder.getDate(),
                            HttpStatus.BAD_REQUEST.value(),
                            null);
            }

            User savedUser = userRepository.save(user);

            return new DataResponse<>(
                    ResponseMessage.DATA_CREATED,
                    "User Created Successfully",
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.CREATED.value(),
                    CreateUserResponseDto.toCreateUserResponseDto(savedUser)
            );

        } catch (Exception e) {
            log.error("Error creating user: {}", e.getMessage());
            return new DataResponse<>(
                    ResponseMessage.MSG_INTERNAL_SERVER_ERROR,
                    "Proses Gagal: " + e.getMessage(),
                    loggingHolder.getPath(),
                    loggingHolder.getDate(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null);
        }
    }
}
