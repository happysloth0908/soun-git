package com.ssafy.food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		System.out.println("컨테이너 객체 생성 시작 - 설정파일 로딩");
		ApplicationContext container = 
				new GenericApplicationContext("");
		}
}
