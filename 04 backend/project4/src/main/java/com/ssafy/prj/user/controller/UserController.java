package com.ssafy.prj.user.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.prj.user.model.dto.ExRecord;
import com.ssafy.prj.user.model.dto.User;
import com.ssafy.prj.user.model.service.UserService;
import com.ssafy.prj.user.model.service.UserServiceImpl;
import com.ssafy.prj.video.model.dto.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet {
	
	UserService userService = UserServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");
			switch(action) {
			case "signupForm":
				signupForm(req, resp);
				break;
			case "signup":
				signup(req, resp);
				break;
			case "loginForm":
				loginForm(req, resp);
				break;
			case "login":
				login(req, resp);
				break;
			case "logout":
				logout(req, resp);
				break;
			case "myPage":
				myPage(req, resp);
				break;
			case "subscribe":
				subscribe(req, resp);
				break;
			case "unSubscribe":
				unSubscribe(req, resp);
				break;
			case "like":
				like(req, resp);
				break;
			case "unLike":
				unLike(req, resp);
				break;
			case "record":
				recording(req, resp);
				break;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	private void unLike(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userInfo");
		String videoId = req.getParameter("video_id");
		userService.unLike(user.getId(), videoId);
		
		String action2 = req.getParameter("action2");
		String path = "/user?action=myPage";
		if(action2 != null && action2.equals("videoDetail")) {
			path = "/video?action=videoDetail&video_id=" + videoId;
		}
		resp.sendRedirect(req.getContextPath() + path);
		
	}

	private void subscribe(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userInfo");
		String channel = req.getParameter("channel");
		userService.subscribe(user.getId(), channel);
		
		String action2 = req.getParameter("action2");
		String path = "/user?action=myPage";
		if(action2 != null && action2.equals("videoDetail")) {
			String videoId = req.getParameter("video_id");
			path = "/video?action=videoDetail&video_id=" + videoId;
		}
		resp.sendRedirect(req.getContextPath() + path);
	}

	private void like(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userInfo");
		String videoId = req.getParameter("video_id");
		userService.like(user.getId(), videoId);
		
		String action2 = req.getParameter("action2");
		String path = "/user?action=myPage";
		if(action2 != null && action2.equals("videoDetail")) {
			path = "/video?action=videoDetail&video_id=" + videoId;
		}
		resp.sendRedirect(req.getContextPath() + path);
		
	}

	private void unSubscribe(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userInfo");
		String channel = req.getParameter("channel");
		userService.unSubscribe(user.getId(), channel);
		
		String action2 = req.getParameter("action2");
		String path = "/user?action=myPage";
		if(action2 != null && action2.equals("videoDetail")) {
			String videoId = req.getParameter("video_id");
			path = "/video?action=videoDetail&video_id=" + videoId;
		}
		resp.sendRedirect(req.getContextPath() + path);
	}

	private void myPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userInfo");
		List<String> subscribe = userService.subscribeList(user.getId());
		List<Video> like = userService.likeList(user.getId());
		List<ExRecord> exRecord = userService.exList(user.getId());
		req.setAttribute("subscribe", subscribe);
		req.setAttribute("like", like);
		req.setAttribute("exRecord", exRecord);
		req.getRequestDispatcher("/user/myPage.jsp").forward(req, resp);
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/main");
	}

	private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
	}

	private void signup(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		User user = new User(id, password, email);
		userService.signup(user);
		
		resp.sendRedirect(req.getContextPath() + "/user?action=loginForm");
	}

	private void login(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		User param = new User();
		param.setId(id);
		param.setPassword(password);
		
		
		User user = null;
		user = userService.login(param);
		String path = ""; // 로그인 실패가 기본
		if(user != null) { // 로그인 성공 시
			path = "/main";
			HttpSession session = req.getSession();
			session.setAttribute("userInfo", user);
		} else {
			path = "/user?action=loginForm&loginChk=failed";
		}
		resp.sendRedirect(req.getContextPath() + path);
	}

	private void signupForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/user/signup.jsp").forward(req, resp);
	}
	
	private void recording(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user = (User)req.getSession().getAttribute("userInfo");
		String part = req.getParameter("part");
		String exDate = req.getParameter("exDate");
		int exTime = Integer.parseInt(req.getParameter("exTime"));
		String userId = user.getId();
		ExRecord exRecord = new ExRecord();
		exRecord.setPart(part);
		exRecord.setExDate(exDate);
		exRecord.setExTime(exTime);
		exRecord.setUserId(userId);
		userService.recording(exRecord);
		
		resp.sendRedirect(req.getContextPath() + "/user?action=myPage");
	}
	
	
	
}
