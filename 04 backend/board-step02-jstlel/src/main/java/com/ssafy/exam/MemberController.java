package com.ssafy.exam;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {

	private MemberDAO memberDao;

	public MemberController() {
		memberDao = MemberDAO.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if (action.equals("join")) {
			join(req, res);
		} else if (action.equals("joinForm")) {
			joinForm(req, res);
		} else if (action.equals("loginForm")) {
			loginForm(req, res);
		} else if (action.equals("login")) {
			login(req, res);
		} else if (action.equals("loginout")) {
			logout(req, res);
		} 
	}

	

	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 HttpSession session = req.getSession();
		 session.invalidate();
		 res.sendRedirect(req.getContextPath() + "/main");
	}

	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		Member param = new Member();
		param.setId(id);
		param.setPassword(password);
		Member member = memberDao.selectMember(param);
		String path = "/member?action=loginForm";
		if (member != null) {	//로그인 성공 : 로그인 상태를 저장하자		
			path = "/main";
			HttpSession session = req.getSession();
			session.setAttribute("memberInfo", member);
		}
		res.sendRedirect(req.getContextPath() + path);
	}

	private void loginForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
		rd.forward(req, res);
	}

	private void joinForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// /member?action=joinForm
		// /member/join.jsp 이동해야 한다.
		RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
		rd.forward(req, res);
	}

	/*
	 * 회원가입 처리
	 * 
	 * @param req
	 * 
	 * @param res
	 * 
	 * @throws ServletException
	 * 
	 * @throws IOException
	 */

	private void join(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Member member = new Member(id, name, password);
		memberDao.insertMember(member);
		
		res.sendRedirect(req.getContextPath() + "/member?action=loginForm");
	}

}
