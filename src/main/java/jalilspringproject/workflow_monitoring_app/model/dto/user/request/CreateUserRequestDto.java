package jalilspringproject.workflow_monitoring_app.model.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {
    private String username;
    private String password;
    private String role;
    private String name;
}
