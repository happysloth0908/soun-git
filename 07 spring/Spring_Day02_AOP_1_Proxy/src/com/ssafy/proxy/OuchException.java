package com.ssafy.proxy;

public class OuchException extends RuntimeException {

	public void handleException() {
		System.out.println("병원 가자");
	}
}
