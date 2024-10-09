package com.ssafy.soun.board.model;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import com.ssafy.soun.board.model.dto.Board;
import com.ssafy.soun.board.model.service.BoardService;
import com.ssafy.soun.board.model.service.BoardServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	
	static BoardService bs = BoardServiceImpl.getInstance();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action = null; 
		try {
		String action = req.getParameter("action");
		if ("list".equals(action)) {
			doList(req, resp);
		} else if ("detail".equals(action)){
			doDetail(req, resp);
		} else if ("delete".equals(action)){
			doBoardDelete(req, resp);
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	

}

	private void doBoardDelete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		bs.deleteBoard(no);
		resp.sendRedirect(req.getContextPath() + "/board?action=list");
	}

	private void doDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 번호를 갖고 그 게시글을 찾아서 정보 가져와야 함. 
		int no = Integer.parseInt(req.getParameter("no"));
		
		Board board = bs.getBoardByNo(no);
		
		req.setAttribute("board", board);
		RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
		
	}

	private static void doList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 리스트로 가기 (포워드 또는 리다이렉트) 이 경우에는... 리다이렉트? 보낼거 없으니까
		// 아님... 주소 노출 싫으니까 포워드해야 함. 
		System.out.println("doList호출");
		// 정보를 넘겨줘야 함. list에 들어갈 내용
		// service 한테 List<Board> 를 달라고 해야 함. 
		List<Board> list = null;
		list = bs.getList();
		
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}