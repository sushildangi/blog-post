package com.luv2tech.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket redditCloneApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luv2tech"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Blog Post API")
                .version("1.0")
                .description("API for Blog Post")
                .termsOfServiceUrl("Free to use")
                .termsOfServiceUrl("http://www.luv2tech.com")
                .contact(new Contact("Sushil Dangi", "http://www.luv2tech.com", "dangi.sushil5@email.com"))
                .license("Apache License Version 2.0")
                .extensions(Collections.emptyList())
                .licenseUrl("http://www.luv2tech.com")
                .build();
    }
}
