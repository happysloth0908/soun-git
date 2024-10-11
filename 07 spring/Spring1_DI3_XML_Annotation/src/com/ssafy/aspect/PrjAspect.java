package com.ssafy.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//공통 기능 클래스
//<aop:aspect ref="prjAspect">
@Aspect
@Component
public class PrjAspect {
//	<aop:aspect ref="prjAspect">
//	<aop:pointcut expression="execution(* com.ssafy.board.model.service.BoardServiceImpl.*(..))" id="pCut"/>
	@Pointcut("execution(* com.ssafy.board.model.service.BoardServiceImpl.*(..))")
	public void pCut() {}
	
//	<aop:before method="log" pointcut-ref="pCut"/>
	@Before("pCut")
	public void log() {
		System.out.println(
				"Time : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
		);
	}
//	<aop:after-returning method="after" pointcut-ref="pCut"/>
	@AfterReturning("pCut()")
	public void after() {
		System.out.println("핵심 기능 메서드 정상 실행 후 호출되었음.");
	}
}
