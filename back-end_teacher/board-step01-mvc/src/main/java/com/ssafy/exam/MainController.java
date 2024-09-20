package com.ssafy.exam;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/board-step01-mvc/main") // 전체 경로를 적지 않아도 톰캣이 알아서 처리해 줌. 
@WebServlet("/main") 
public class MainController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//main.jsp페이지로 이동하자
		// 2 가지 방식 가능 - 포워드, 리다이렉트 방식
		// 포워드 => request 객체 이용
		// 리다이렉트 => response 객체 이용
		// 지금은 객체 두개 다 있으니까 둘 다 활용 가능
		
		// 1. 포워드 방식
		// - RequestDispather 객체를 얻어야 함 
		// - 객체.forward 메서드 호출하기 ->  그럼 페이지 이동함. 
		// * 같은 프로젝트 내에 있는 페이지로만 이동 가능
		//  - 호출된 서블렛의 주소가 유지된다. 
		//http://localhost:8080/board-step01-mvc/main   req, res 생성
		//http://localhost:8080/board-step01-mvc/main.jsp  req, res - 동일한 객체 전달
		// 
		
		// /board-step01-mvc/main.jsp (ContextRoot Path 경로) 생략 가능 
		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp"); //동일한 프로젝트 내니까 요약 가능 
		//RequestDispatcher rd = req.getRequestDispatcher("main.jsp"); // /가 빠져도 똑같음.... 뭐가 차이지..
		//rd.forward(req, res);
		
		// 2. 리다이렉트 방식
		// - 응답객체의 sendRedirect  메서드를 이용
		// - 다른 프로젝트, 타 사이트로 이동 가능
		// - 호출된 서블렛의 주소가 유지되지 않고 리다이렉트 된 페이지로 변경
		// - 요청이 2번 발생한다. (요청 시 만들어진 req 에 등록된 정보를 사용할 수 없다. )
		// - 응답코드를 302번으로 설정, Location 헤더의 값으로 페이지 주소를 넘겨준다. 
		//	res.sendRedirect("/board-step01-mvc/main.jsp"); // 얘는 프로젝트 주소 꼭! 줘야 함
		
		//res.sendRedirect("main.jsp"); // 근데 얘도 서블렛 까지의 주소는 같으니까 /가 없으면 주고의 맨 마지막만 바뀜. 
	
		//http://localhost:8080/board-step01-mvc/main
		//http://localhost:8080/board-step01-mvc/main.jsp
	
	}
	
}
