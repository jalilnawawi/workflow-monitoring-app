package jalilspringproject.workflow_monitoring_app.model.dto.user.response;

import jalilspringproject.workflow_monitoring_app.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponseDto {
    private String id;
    private String username;
    private String role;
    private String name;

    public static CreateUserResponseDto toCreateUserResponseDto(User user){
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        createUserResponseDto.setId(user.getId().toString());
        createUserResponseDto.setUsername(user.getUsername());
        createUserResponseDto.setRole(user.getRole().name());
        createUserResponseDto.setName(user.getName());
        return createUserResponseDto;
    }
}
