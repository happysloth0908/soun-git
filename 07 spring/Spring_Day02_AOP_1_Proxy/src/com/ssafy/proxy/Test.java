package com.ssafy.proxy;

public class Test {
	public static void main(String[] args) {
		Programmer p = new Programmer();	// 스프링 컨테이너가 빈등록했으면 알앗거	
		PersonProxy px = new PersonProxy();
		px.setPerson(p);
		
		px.coding();
		
	}
}
