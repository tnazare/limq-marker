package com.limq.marker.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("LIMQ Marker")
            .description("LIMQ Marker application")
            .version("v0.0.1"));
    }
}
