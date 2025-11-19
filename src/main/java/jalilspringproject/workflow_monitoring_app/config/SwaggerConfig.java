package jalilspringproject.workflow_monitoring_app.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authorization",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
    @Bean
    public OpenAPI springAppOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Workflow Monitoring API Services")
                        .description("RESTful API Workflow Monitoring Services")
                        .version("v0.0.1")
                        )
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authorization")); // Keep this as "Bearer Authorization"
    }
}
