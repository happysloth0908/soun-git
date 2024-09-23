package com.ssafy.offline;
/*
 * 제너릭타입 : class 클래스이름<타입파라미터>
 * 제너릭메서드 : <타입파라미터> 반환타입 메서드명(매개변수)
 */
class GenericMethod {
	public <T> void printTypeInfo(T t) {
		System.out.println("메서드에 들어온 타입 파라미터의 정보 : " + t.getClass().getName());
	}
	public <T> void printTypeInfo2(T t) {
		System.out.println("메서드에 들어온 타입 파라미터의 정보 : " + t.getClass().getName());
	}
}
public class GenericType2 {
	public static void main(String[] args) {
		GenericMethod gm = new GenericMethod();
		gm.<Integer>printTypeInfo(100);
		gm.printTypeInfo("hello");
	}
}







