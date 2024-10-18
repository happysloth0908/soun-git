package com.ssafy.myBoard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { // web 설정파일

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/files/**" 경로로 요청이 들어오면 "C:/external-resources/" 디렉토리에서 파일을 찾습니다.
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///C:/SSAFY/uploads/");
    }
}