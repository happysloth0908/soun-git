package com.ssafy.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;

// FileDownloadView 를 jsp 가 아니라 class 에서 먼저 찾게 하기 위해 순서를 부여한 것임. 
@Configuration
public class JavaConfig {

	public BeanNameViewResolver beanNameViewResolver () {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(0);
		return beanNameViewResolver;
	}
		
}
