package com.ssafy.board.controller;

import java.io.IOException;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/board")
public class BoardController extends HttpServlet{

	private BoardService service = BoardServiceImpl.getInstance();
	
	private static final long serialVewrsionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case "writeform" :
			doWriteForm(req, resp);
			break;
		case "doWrite" :
			doWrtie(req,resp);
		case "list" :
			doList(req, resp);
		
		}
		
		}
	private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", service.getList());
		req.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(req, resp);
	}
	private void doWrtie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		Board board = new Board(title, writer, content);
		
		service.writeBoard(board);
		
		resp.sendRedirect("board?action=list");
		
	}
	

	private void doWriteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/board/writeform.jsp").forward(req, resp);
		
	}
	
	

}
