package jalilspringproject.workflow_monitoring_app.controller;

import jalilspringproject.workflow_monitoring_app.model.base_response.DataResponse;
import jalilspringproject.workflow_monitoring_app.model.dto.user.request.CreateUserRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.user.response.CreateUserResponseDto;
import jalilspringproject.workflow_monitoring_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<DataResponse<CreateUserResponseDto>> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        DataResponse<CreateUserResponseDto> response = userService.createUser(createUserRequestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
