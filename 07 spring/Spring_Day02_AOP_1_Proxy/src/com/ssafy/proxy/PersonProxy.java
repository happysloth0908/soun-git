package com.ssafy.proxy;

import java.util.Random;

public class PersonProxy implements Person{

	private Person person;
	
	//설정자 주입
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("컴퓨터 부팅한다. "); // 이전에 수행해야 할 기능
		try {
			person.coding();// 핵심 관심 사항
			
			if(new Random().nextBoolean())
				throw new OuchException();
			System.out.println("깃에 commit하기. "); // 정상 마무리 기능
		} catch (OuchException e) {
			e.handleException();
			System.out.println("조퇴한다"); // 비정상 마무리
		} finally {
			System.out.println("침대와 한 몸이 된다."); // 모든게 마무리 되었을 때 (정상이든 비정상 마무리든)
		}
	}
	
	
}
