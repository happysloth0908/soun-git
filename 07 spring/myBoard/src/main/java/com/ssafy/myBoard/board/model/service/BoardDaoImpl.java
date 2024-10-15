package com.ssafy.myBoard.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
					INSERT INTO board (title, writer, content, reg_date ) VALUE ( ?, ? ,? , CURRENT_TIMESTAMP())
					"""
					);
				
					
				){
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
			
		}
		
	}

	@Override
	public Board getBoardByNo(int no) throws SQLException {
		System.out.println("BoardDaoImpl에서 getBoardByNo 호출됨. ");
		Board board = new Board();
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"""
					SELECT no, title, writer, view_cnt, reg_date FROM board WHERE no = ?
					"""
					);
				){
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));
			}else {
				System.out.println(no + "번 게시글이 없습니다.");
				return null;
			}
				}
		return board;
	}

}
