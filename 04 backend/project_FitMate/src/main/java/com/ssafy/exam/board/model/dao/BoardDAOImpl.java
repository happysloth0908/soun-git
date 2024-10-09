package com.ssafy.exam.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// ctrl + shift + O
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.util.DBUtil;


// CRUD
/*
 * 데이터베이스 처리 기준
 * R : selectBoard(전체)
 *   : selectBoardByPK(하나조회)
 * C : insertBoard  
 * U : updateBoard  
 * D : deleteBoard  
 * 
 */
public class BoardDAOImpl implements BoardDAO{
	
	public static void main(String[] args) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		System.out.println(con);
	}
	
	
	public List<Board> selectBoard() throws SQLException{
		List<Board> list = new ArrayList<>();
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		// 실행할 SQL문 작성 
		String sql = "select no, title, writer, view_cnt from board order by no desc";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int viewCnt = rs.getInt("view_cnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setViewCnt(viewCnt);
			list.add(board);
		}
		
		return list;
	}
	
	// 게시글 번호
	private static int boardNo;
	private static BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private List<Board> boardList = new ArrayList<>();
	public void insertBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "insert into board(title, writer, content) values(?,?,?)";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		pstmt.executeUpdate();
		
	}
	
	
	public Board selectBoardByNo(int no) throws SQLException {
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "select no, title, writer, content, view_cnt from board where no = ?";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setInt(1, no); // 첫번째 받아온 ?에 no값을 주자.
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String content = rs.getString("content");
			int viewCnt = rs.getInt("view_cnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			board.setViewCnt(viewCnt);
			return board;
		}
		
		return null;
	}
	
	
	
	
	
	public void deleteBoard(int no) throws SQLException {
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "delete from board where no = ?";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setInt(1, no); // 첫번째 받아온 ?에 no값을 주자.
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		pstmt.executeUpdate();
	}
	
	
	public void updateViewCnt(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		String sql = "update board\r\n"
				+ "	set view_cnt = view_cnt + 1\r\n"
				+ "where no = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		
		// select -> 익스큐트쿼리
		// select 외 -> 익스큐트 업데이트
		
		
		for(Board b : boardList) {
			if(b.getNo() == no) {
				b.setViewCnt(b.getViewCnt() + 1);
				return;
			}
		}
	}
	public void updateBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "update board set title=?, writer=?, content=? where no =?";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);

		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3,  board.getContent());
		pstmt.setInt(4,  board.getNo());
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		pstmt.executeUpdate();
	}


	
	
	
}





