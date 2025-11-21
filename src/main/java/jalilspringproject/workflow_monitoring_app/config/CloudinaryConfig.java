package jalilspringproject.workflow_monitoring_app.config;

import com.cloudinary.Cloudinary;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dh4lpu0ej");
        config.put("api_key", "461921844647699");
        config.put("api_secret", "3mIc5e9KOgNa-wCcQ3Uj1Upvn58");
        return new Cloudinary(config);
    }
}
