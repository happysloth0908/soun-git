package com.ssafy.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

//공통 기능 클래스
public class PrjAspect {
	public void log() {
		System.out.println(
				"Time : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
		);
	}
	
	public void after() {
		System.out.println("핵심 기능 메서드 정상 실행 후 호출되었음.");
	}
}
