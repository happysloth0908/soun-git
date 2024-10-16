package com.ssafy.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	LoginInterceptor interceptor;
	public WebConfig(LoginInterceptor interceptor){
		this.interceptor = interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/board/list");
	}
	
	
}
