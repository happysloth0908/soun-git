package com.soun.exam;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import com.soun.dao.MemberDAO;
import com.soun.dto.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet{
	
	MemberDAO memberDao; // 생성자 아님 그냥 멤버다오 타입의 객체 
	public MemberController() { // 얘 생성되자마자 멤버다오 받아오게 
		memberDao = MemberDAO.getMemberDao(); // 클래스명.get 해도 됨. static으로 올려놨으니까  
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("joinForm".equals(action))//이렇게 써야 action 이 null 값이 와도 오류 안남. 
		{
		joinForm(req, res);
		}else if ("join".equals(action)) {
			join(req, res);
		}else if("loginForm".equals(action)) {
			loginForm(req, res);
		}else if("login".equals(action)) {
			login(req, res);
		}
	}

	

	private void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		//Member member = new Member(id,password, null); 이렇게 하면 파라미터 값 순서 헷갈릴 수 잇으니까
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		
		memberDao.loginMember(member);
		
		if(member != null) { // 로그인 성공했으면
			HttpSession session = req.getSession();
			session.setAttribute(id, member);
			res.sendRedirect(req.getContextPath() + "/main");
			
		}
		res.sendRedirect(req.getContextPath() + "/member?action=loginForm");
	}

	private void loginForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/loginForm.jsp");
		rd.forward(req, res);
	}

	private void join(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id"); // 문자열 값을 받아와 줘야 해서 ""붙임.
		String password = req.getParameter("password"); // 문자열 값을 받아와 줘야 해서 ""붙임.
		String name = req.getParameter("name"); // 문자열 값을 받아와 줘야 해서 ""붙임.
		
		Member member = new Member(id, password, name);
		
		memberDao.insertMember(member);
		
		// 포워드랑 리다이렉트 전화 상담원 예시 생각하기 
		res.sendRedirect(req.getContextPath() + "/member?action=loginForm"); // 회원가입 했으면 로그인 파일로 가기 
		
	}

	private void joinForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/joinForm.jsp");
		rd.forward(req, res);
	}

	
}
