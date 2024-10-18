package com.ssafy.myBoard.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.BoardFile;
import com.ssafy.myBoard.board.model.dao.BoardDao;
import com.ssafy.myBoard.config.MyBatisConfig;
import com.ssafy.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private final String NS = "com.ssafy.myBoard.board.model.dao.BoardDao.";
	private SqlSessionFactory sqlFactory;
//	private DBUtil db;
	
	public BoardDaoImpl() {
		sqlFactory = MyBatisConfig.getFactory();
//		db = DBUtil.getInstance();
	}

	@Override
	public List<Board> selectBoard()  {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			// xml id -> selectBoard
			return sqlSession.selectList(NS + "selectBoard");
			 
		}
		
		// 이제 이만큼 생략 가능!
		//throws SQLException 생략 가능! 마이바티스는 예외처리 내부적으로 한 다음에 런타임으로 변환함. 
//		
//		try (
//			Connection con = db.getConnection();
//			PreparedStatement pstmt = con.prepareStatement(
//					"""
//					SELECT no, title, writer, view_cnt, reg_date FROM board ORDER BY NO DESC
//				
//					"""	);
//			
//			){
//			List<Board> list = new ArrayList<>();
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Board board = new Board();
//				board.setNo(rs.getInt("no"));
//				board.setWriter(rs.getString("writer"));
//				board.setTitle(rs.getString("title"));
//				board.setViewCnt(rs.getInt("view_cnt"));
//				board.setRegDate(rs.getString("reg_date"));
//				list.add(board);
//				
//			}
//			return list;
//		}
	}

	@Override
	public Board getBoardByNo(int no) {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			return sqlSession.selectOne(NS + "getBoardByNo", no);
		}
	}

	@Override
	public void insertBoard(Board board) {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			sqlSession.insert(NS + "insertBoard", board);
			sqlSession.commit();
		}
	}

	@Override
	public void insertBoardFile(BoardFile boardFile)  {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			sqlSession.insert(NS + "insertBoardFile", boardFile);
			sqlSession.commit();
		}
	}

	@Override
	public BoardFile selectBoardFileByNo(int no)  {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			return sqlSession.selectOne(NS + "selectBoardFileByNo", no);
		}
	}
	
	
	
//	@Override
//	public void registBoard(Board board) throws SQLException {
//		try(
//				Connection con = db.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(
//					"""
//					INSERT INTO board (title, writer, content, reg_date ) VALUE ( ?, ? ,? , CURRENT_TIMESTAMP())
//					"""
//						);
//				
//				
//				){
//			pstmt.setString(1, board.getTitle());
//			pstmt.setString(2, board.getWriter());
//			pstmt.setString(3, board.getContent());
//			pstmt.executeUpdate();
//			
//		}
//		
//	}
//
//	@Override
//	public void insertBoardFile(BoardFile boardFile) throws SQLException {
//		try (
//				Connection con = db.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(
//						"""
//						insert into board_file (file_path, ori_name, system_name, no)
//						values ( ?, ? , ? ,? )
//						"""
//						)
//						
//				){
//			
//			
//		}
//		
//		}


}
