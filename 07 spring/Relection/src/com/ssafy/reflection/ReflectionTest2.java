package com.ssafy.reflection;

import java.lang.reflect.Method;

/*
 * 1. 클래스 정보 접근
 * [2. 메서드 정보 접근]
 * 3. 객체 생성과 메서드 실행
*/


public class ReflectionTest2 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		//  Dog 클래스의 정보 알기 
		Class<?> clz = Dog.class;
		//Dog 클래스에 선언된 메서드 정보 얻기
		Method[] methods = clz.getDeclaredMethods();
		//Dog 클래스에 있는 모든 메서드들을 출력할 수 있음. 
		for (Method m : methods) {
			System.out.println(m.getName());
		}
//		Method method = clz.getDeclaredMethod("setName"); // 오버로딩한 경우는 못 씀. 이렇게만 쓰면 setName 이 여러개면 어쩜 
		
		//String name, Class<?> 
		Method method = clz.getDeclaredMethod("setName", String.class);
		System.out.println(method.getName());
		
		// String.class 라고 하면 
	}

}
