package com.luv2tech.config;

import com.luv2tech.audit.AuditorAwareImpl;
import com.luv2tech.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Configuration
public class AppConfig {

    @Bean
    public AuditorAware<User> auditorAware() {
        return new AuditorAwareImpl();
    }
}
