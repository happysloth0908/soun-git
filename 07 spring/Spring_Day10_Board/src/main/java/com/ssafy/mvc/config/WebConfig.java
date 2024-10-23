package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.AdminInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	//의존성 주입
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//users 라는 명령이 url에 들어오면 작동시키겠다!
		registry.addInterceptor(adminInterceptor).addPathPatterns("/users");
		
	}

}
