package com.ssafy.exam.board.controller;

import java.io.IOException;

import com.ssafy.exam.board.model.dao.BoardDAO;
import com.ssafy.exam.board.model.dao.BoardDAOImpl;
import com.ssafy.exam.board.model.dto.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 *  action 파리미터의 값으로 각각의 동작을 구분
 *  등록폼	: writeForm
 *  등록	: write
 *  목록	: list
 *  삭제 : delete
 *  수정폼 : updateForm
 *  수정 : update
 *  상세조회 : detail
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {

	private BoardDAO boardDao;

	public BoardController() {
		boardDao = BoardDAOImpl.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case "writeform": 
			doWriteForm(req, resp);
			break;
		case "write":
			doWrite(req, resp);
			break;
		case "list":
			doList(req, resp);
			break;
		case "detail":
			doDetail(req, resp);
			break;
		case "delete":
			doRemove(req, resp);
			break;
		case "updateform":
			doUpdateForm(req, resp);
			break;
		case "update":
			doUpdate(req, resp);
			break;
		default:
			System.out.println("에러페이지로 가라");
			break;
		}
			
		
		
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Board board = service.getBoard(Integer.parseInt(request.getParameter("id")));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		service.modifyBoard(board);
		
		response.sendRedirect("board?action=list");
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Board board = service.getBoard(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/board/updateform.jsp").forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		service.removeBoard(id);
		response.sendRedirect("board?action=list");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("board", service.getBoard(id));
		request.getRequestDispatcher("/WEB-INF/board/detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//객체를 만들겠다.
		Board board = new Board(title, writer, content);
		
		service.writeBoard(board);
		
		//1. 등록한 게시글을 보러가는법
		
		//2. 게시글 전체목록으로 가는법 (V)
		response.sendRedirect("board?action=list");
		
		
		
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/board/writeform.jsp").forward(request, response);
	}
	

}
