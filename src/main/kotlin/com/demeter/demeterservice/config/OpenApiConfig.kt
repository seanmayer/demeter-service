package com.demeter.demeterservice.config

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("public")
            .pathsToMatch("/api/**")
            .build()
    }

    @Bean
    fun apiInfo(): Info {
        return Info()
            .title("Demeter Service API")
            .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
            .version("1.0.0")
    }
}