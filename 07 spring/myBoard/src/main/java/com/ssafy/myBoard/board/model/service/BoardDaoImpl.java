package com.ssafy.myBoard.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.dao.BoardDao;
import com.ssafy.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private DBUtil db;
	
	public BoardDaoImpl() {
		db = DBUtil.getInstance();
	}

	@Override
	public List<Board> selectBoard() throws SQLException {
		try (
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"""
					SELECT no, title, writer, view_cnt, reg_date FROM board ORDER BY NO DESC
				
					"""	);
			
			){
			List<Board> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
				
			}
			return list;
		}
	}

	@Override
	public void registBoard(Board board) throws SQLException {
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"""
					INSERT INTO board (title, writer, content, reg_date ) VALUE ( ?, ? ,? , CURRENT_TIMESTAMP());
					"""
					)
				
			pstmt.
			ResultSet rs = pstmt.executeQuery();
					
				){
			
		}
		
	}

}
