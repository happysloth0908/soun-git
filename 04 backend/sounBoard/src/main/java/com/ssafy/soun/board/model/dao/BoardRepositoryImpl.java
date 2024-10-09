package com.ssafy.soun.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.soun.board.model.dto.Board;
import com.ssafy.soun.util.DBUtil;



public class BoardRepositoryImpl implements BoardRepository{
	// Util 에서 인스턴스 가져오기
	DBUtil dbUtil;
	BoardRepositoryImpl(){
		dbUtil = DBUtil.getInstance();
	}
	
	// service 에서 인스턴스 가져갈 수 있게 만들어두기
	static BoardRepository instance = new BoardRepositoryImpl();
	
	public static BoardRepository getInstance() {
		return instance;
	}

	@Override
	public List<Board> getList() throws Exception {
		String sql = "SELECT no, prob_no, prob_name, writer, time, view_cnt FROM board ORDER BY no DESC";
		List<Board> list = new ArrayList<>();

		try(// 저절로 close 가 되도록 try에 넣기
				//디비랑 연결하기 
				Connection con = dbUtil.getConnection();
				// sql 문 작성하기 
				// sql 문 실행시킬 애 데려오기
				PreparedStatement pstmt = con.prepareStatement(sql);
				//sql 문 실행시키기, 실행시킨걸 rs 에 넣기
				ResultSet rs = pstmt.executeQuery();				
				){
			
			while(rs.next()) {
				int no = rs.getInt("no");
				int probNo = rs.getInt("prob_no");
				String probName = rs.getString("prob_name");
				String writer = rs.getString("writer");
				String time = rs.getString("time");
				int viewCnt = rs.getInt("view_cnt");
				Board board = new Board();
				board.setNo(no);
				board.setProbNo(probNo);
				board.setProbName(probName);
				board.setWriter(writer);
				board.setTime(time);
				board.setViewCnt(viewCnt);
				list.add(board);
			
		}
		
		}
		
		return list;
		
	}
	

	@Override
	public Board getBoardByNo(int no) throws Exception {
		Board board = new Board();
		String sql = "SELECT * FROM board WHERE no = ? "; // 얘는 close 안 됨. 
		try(
			Connection con = dbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
				
				){
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {			
				board.setNo(rs.getInt("no"));
				board.setProbNo(rs.getInt("prob_no"));
				board.setProbName(rs.getString("prob_name"));
				board.setWriter(rs.getString("writer"));
				board.setAns(rs.getString("ans"));
				board.setTime(rs.getString("time"));
				board.setViewCnt(rs.getInt("view_cnt"));
		}
		}
		
		return board;
		
	}

	@Override
	public void updateViewCnt(int no) throws Exception {
		Connection con = dbUtil.getConnection();
		String sql = "UPDATE board SET view_cnt = view_cnt + 1 WHERE no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate(); // 얘는 ResultSet 아님. 딱히 불러올 필요 없음. 쿼리문을 통해 업데이트 하는 거
	}

	@Override
	public void deleteBoard(int no) throws Exception {
		String sql = "DELETE FROM board WHERE no = ?";
		try(
			Connection con = dbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
		
	}
	
}
