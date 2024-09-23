/*
 * 객체 생성 불가능
 * 자식클래스를 이용해서 사용한다.
 * 클래스가 인터페이스를 구현하기 위해서 
 * "implements" 키워드 사용
 * 
 * 인터페이스 extends 인터페이스(다중상속)
 * 클래스 implements 인터페이스, 인터페이스, ... (다중구현)
 * 클래스 extends 클래스(단일상속)
 * 
 */
package com.ssafy.offline;

public interface Server {
	int PORT = 80;  // public final static
	public abstract void start();
	public abstract void stop();
	void restart();
}










