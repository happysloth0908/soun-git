package com.ssafy.aop;

import java.util.Random;

public class Ssafy implements Person {

	public int coding() {
		System.out.println("열심히 공부를 한다. "); // 핵심 관심 사항
		// 그냥 연습을 위해 오류를 던지는거임.
		if (new Random().nextBoolean()) {
			throw new OuchException();
		}
		return (int) (Math.random() * 100) + 1;

	}
}
