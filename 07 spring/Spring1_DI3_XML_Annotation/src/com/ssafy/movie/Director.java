package com.ssafy.movie;

import org.springframework.stereotype.Component;

@Component
// 컴포넌트는 빈 관리할 클래스에 붙임. 
public class Director {
	private String name = "빵찜"; // 감독 이름
	
	public void setName(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
