package com.utkarsh.bookmanager.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("dev")
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenAPI() {

        SecurityScheme bearerJwt = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        return new OpenAPI()
                .info(new Info()
                        .title("Book Manager API")
                        .description("Spring Boot project to manage books with JWT auth"))
                .tags(List.of(
                        new Tag().name("Health Check"),
                        new Tag().name("User Control API"),
                        new Tag().name("Book Manager")
                ))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerJwt))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }

}
