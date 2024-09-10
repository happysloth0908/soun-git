package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private Map<String, String> members = new HashMap<>();
	public LoginServlet() {
		members.put("ssafy", "ssafy");
		members.put("admin", "admin");
	}
	
	// http://localhost:8080/offline-prj/login?id=soun&password=1202
	public void service(HttpServletRequest re, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		// ssafy
		String id = re.getParameter("id");
		// 1234, ssafy
		String password = re.getParameter("password");
		
		String result = "로그인 실~패!";
		String pass = members.get(id); //받은 id 에 해당하는 비밀번호를 get 해주세요~! -> 없으면 null
		if(pass != null) { 
			if(password.equals(pass)) {
				result = "로그인 성공~!!";
			}
		}

		out.print("""
								
				<html>
				<head>
				  <title>연습</title>
				</head>
				<body>
					<h2>아이디 : %s  </h2>
					<h2>패스워드 : %s</h2>
					<h2> %s <h2>
				</body>
				</html>
								""".formatted(id,password, result));
		out.close();

	}
}
