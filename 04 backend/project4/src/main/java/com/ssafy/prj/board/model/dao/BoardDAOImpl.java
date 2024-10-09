package com.ssafy.prj.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// ctrl + shift + O
import java.util.ArrayList;
import java.util.List;

import com.ssafy.prj.board.model.dto.Board;
import com.ssafy.prj.util.DBUtil;


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
	
	
	
	
	// 게시글 번호
	private static BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private List<Board> boardList = new ArrayList<>();
	
	@Override
	public void insertBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "insert into review(title, content, user_id, video_id) values(?,?,?,?)";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getUser_id());
		pstmt.setString(4, board.getVideo_id());
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		pstmt.executeUpdate();
		
	}
	@Override
	public List<Board> selectBoard(String video_id) throws SQLException{
		List<Board> list = new ArrayList<>();
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		// 실행할 SQL문 작성 
		String sql = "select review_id, title, user_id, view_cnt, reg_time from review where video_id = ? order by review_id desc";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, video_id);
		//pstmt.setString(1, "50WCSpZtdmA");
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
		    Board board = new Board();
		    board.setReview_id(rs.getInt("review_id"));
		    board.setTitle(rs.getString("title"));
		    board.setRegTime(rs.getString("reg_time"));
		    board.setUser_id(rs.getString("user_id"));
		    board.setView_cnt(rs.getInt("view_cnt"));
		    list.add(board);
		}
		
		return list;
	}
	
	@Override
	public Board selectBoardByReview_id(int review_id) throws SQLException {
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "SELECT review_id, title, content, reg_time, video_id, user_id, view_cnt FROM review WHERE review_id = ?";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setInt(1, review_id); // 첫번째 받아온 ?에 no값을 주자.
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
	        Board board = new Board();
	        board.setReview_id(rs.getInt("review_id"));
	        board.setTitle(rs.getString("title"));
	        board.setContent(rs.getString("content"));
	        board.setRegTime(rs.getString("reg_time"));
	        board.setVideo_id(rs.getString("video_id"));
	        board.setUser_id(rs.getString("user_id"));
	        board.setView_cnt(rs.getInt("view_cnt"));
	        return board;
	    }
		
		return null;
	}
	
	
	
	
	@Override
	public void deleteBoard(int review_id) throws SQLException {
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "delete from review where review_id = ?";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setInt(1, review_id); // 첫번째 받아온 ?에 no값을 주자.
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		pstmt.executeUpdate();
	}
	
	@Override
	public void updateViewCnt(int review_id) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		String sql = "UPDATE review SET view_cnt = view_cnt + 1 WHERE review_id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, review_id);
		pstmt.executeUpdate();
		
		// select -> 익스큐트쿼리
		// select 외 -> 익스큐트 업데이트
		
		
		for(Board b : boardList) {
			if(b.getReview_id() == review_id) {
				b.setView_cnt(b.getView_cnt() + 1);
				return;
			}
		}
	}
	
	public void updateBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기 
		Connection con = dbUtil.getConnection();
		
		// 실행할 SQL문 작성 
		String sql = "UPDATE review SET title=?, content=? WHERE review_id=?";
		
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);

		// SQL문을 실행 전에 ?에 값을 설정하자.
		pstmt.setString(1, board.getTitle());
	    pstmt.setString(2, board.getContent());
	   // pstmt.setString(3, board.getRegTime());
	    //pstmt.setString(4, board.getVideo_id());
	    //pstmt.setString(5, board.getUser_id());
	    pstmt.setInt(3, board.getReview_id());
		
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		pstmt.executeUpdate();
	}





	
	
	
}





