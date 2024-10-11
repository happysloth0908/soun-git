package com.ssafy.aop;

// 공통 관심사항을 한방에 저장할 클래스 (단위)
public class MyAspect {

	public void before() {
		System.out.println("컴퓨터 부팅한다. "); // 이전에 수행해야 할 기능
	}
	public void afterReturning(int num) {
		System.out.println("깃에 commit하기. " + num + "시간을"); // 정상 마무리 기능
	}
	
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if(th instanceof OuchException) // 옛날에 자바에서 해봄. 
			((OuchException)th).handleException();
	}
	public void after() {
		System.out.println("침대와 한 몸이 된다."); // 모든게 마무리 되었을 때
	}

}
