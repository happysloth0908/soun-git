package com.ssafy.mvc.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//이렇게 빈 등록하면 단점: 경로를 지정할 수 없음.. 그래서 모든 요청에 대해 이 필터가 적용될거임. 
//@Component url 설정 안 됨.
//@Order(1) // 이걸로 순서 지정 가능함
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("서블렛 전");
		chain.doFilter(request, response);
		System.out.println("서블렛 후");
		
	}


}
