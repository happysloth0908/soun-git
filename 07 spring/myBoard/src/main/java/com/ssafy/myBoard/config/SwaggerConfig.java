package com.ssafy.myboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI() {
	      return new OpenAPI()
	            .info(
            		new Info().title("Spring Boot Board REST API")
            		.description("SSAFT Board 입니다.")
            		.version("v0.0.1")
            		.license(
            				new License()
            				.name("Apache 2.0")
            				.url("http://springdoc.org"))
	            ); 
	  }
}






