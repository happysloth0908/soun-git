package com.ssafy.reflection;

import java.util.ArrayList;
import java.util.Random;

/*
 *[ 1. 클래스 정보 접근]
 * 2. 메서드 정보 접근
 * 3. 객체 생성과 메서드 실행
*/


public class ReflectionTest1 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 클래스 정보 접근 3가지 방법
		/*
		 * 1. 클래스이름.class
		 * 2. 객체.getClass()
		 * 3. Class.forName(패키지.클래스이름)
		 * 
		*/
		//1
		Class<?> clz1 = Dog.class;
		
		//2
		Dog dog = new Dog();
		Class<?> clz2 = dog.getClass();
		
		//3
		Class<?> clz3 = Class.forName("com.ssafy.reflection.Dog");
		
		// 셋 다 같은 주소를 갖고 있음.
		System.out.println("셋 다 같은 값?");
		System.out.println(clz1 == clz2);
		System.out.println(clz2 == clz3);
		
		// DBUtil 클래스와 비슷하게 생김. 
		// 1번이 짧아서 좋은데 문자열밖에 정보가 없으면 3번으로만 접근 가능. 
		
		System.out.println("---------");
		System.out.println(clz1.getSimpleName());
		System.out.println(clz1.getName()); // 패키지명도 포함해서 반환해줌. AOP 에 있는 advice 와 비슷함? 
		
		System.out.println("---------");
		Object obj = getRandomObject();
		Class<?> clz = obj.getClass();
		System.out.println(clz.getName());
		switch(clz.getName()) {
		case "java.lang.String":
		case "java.util.ArrayList":
		}
		System.out.println("---------");
		
	}
	
	private static Object getRandomObject() {
		Object[] arr = {
				new String("a"),
				new Dog(),
				new ArrayList<>()
		};
		return arr[new Random().nextInt(arr.length)];
	}

}
