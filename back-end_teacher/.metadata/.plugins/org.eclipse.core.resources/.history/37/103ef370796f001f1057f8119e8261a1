package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
/*
 * 사용자가 전송한 제목, 내용, 작성자 파라미터 꺼낸다. 
 * 꺼낸 데이터를 사용자에게 확인 시켜준다.
 * -----------------
 * 번호   제목   작성자
 * ----------------
 * 1  작성한 제목   작성한 이름
 * ----------------
 *  
 */
	public class Board{
		String title;
		String content;
		String writer;
		
		public Board(String title, String content, String writer) {
			super();
			this.title = title;
			this.content = content;
			this.writer = writer;
		}
	}
	
	public void Service(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException{
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String title = req.getParameter("tittle");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
	}
}
