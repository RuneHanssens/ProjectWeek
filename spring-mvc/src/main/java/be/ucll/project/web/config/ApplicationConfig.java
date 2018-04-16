package be.ucll.project.web.config;

import be.ucll.project.domain.ActivityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ActivityService service(){
        return new ActivityService("JPA");
    }
}
