package com.ssafy.exam;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	/*
	 * action 파라미터의 값으로 각각의 동작을 구분 등록폼 : writeForm 등록 : write 목록 : list 삭제 : delete
	 * 수정폼 : updateForm 수정 : update 상세조회 : detail
	 */
	
	private BoardDAO boardDao;
	public BoardController () {
		boardDao = BoardDAO.getInstance();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("list".equals(action)) {
			// 목록 페이지도 이동하자...
			list(req, res);

		} else if ("writeForm".equals(action)) {
			// 등록폼 페이지도 이동하자...
			writeForm(req, res);

		} else if ("write".equals(action)){
			// 등록 처리하자...
			write(req, res);
			
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		// 화면에 보여줄 데이터를 준비함. 
		
		// 목록 페이지로 이동한다. 
		RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
		rd.forward(req,res);
	}

	private void write(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		// 등록할 데이터를 파라미터에서 꺼낸다. 
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		
		
		Board board = new Board();// 여기부터 놓쳐서 따라 적기 포기... 
		
		
		
		System.out.println("title : " + title);
		System.out.println("writer : " + writer);
		System.out.println("content : " + content);
		// 등록한다.
		//http://localhost/board-step01-mvc/board
		// 목록 페이지로 이동한다.(list.jsp 로 바로 가면 안 됨!!!목록에 필요한 데이터를 준비하는 서블릿으로 이동)
		RequestDispatcher rd = req.getRequestDispatcher("/board?action=list");
		rd.forward(req, res);
		
//		res.sendRedirect("/board-step01-mvc/board?action=list");
	}

	private void writeForm(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		// 등록 페이지로 이동한다. 
		RequestDispatcher rd = req.getRequestDispatcher("/board/writeForm.jsp");
		rd.forward(req,res);
		System.out.println("writeForm 실행");
	}



}
