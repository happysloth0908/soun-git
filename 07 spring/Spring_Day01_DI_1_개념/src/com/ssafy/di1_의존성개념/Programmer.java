package com.ssafy.di1_의존성개념;

public class Programmer {
	private Desktop desktop;
	
	public Programmer() {
		// 프로그래머를 한 명 고용하면 무조건 컴퓨터 한 대 사줌. 
		this.desktop = new Desktop();
	}
	
	public Coding() {
		
	}
}
