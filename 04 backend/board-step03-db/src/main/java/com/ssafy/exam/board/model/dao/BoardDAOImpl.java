package com.ssafy.exam.board.model.dao;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//ctrl shift o  -> import  자동으로 해줌.  
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.util.DBUtil;

// CRUD
/*
 * 데이터베이스 처리 기준
 * 
 * R : selectBoard(전체)
 *   : selectBoardByPK(하나조회)
 * C : insertBoard  
 * U : updateBoard  
 * D : deleteBoard  
 */
public class BoardDAOImpl implements BoardDAO {

	public static void main(String[] args) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		System.out.println(con);
	}

	// 게시글 번호
	private static int boardNo;
	private static BoardDAO instance = new BoardDAOImpl();

	private BoardDAOImpl() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}


	@Override
	public List<Board> selectBoard() throws SQLException {
		List<Board> list = new ArrayList<>();

		DBUtil dbUtil = DBUtil.getInstance(); // 데이터 베이스 연결하기
		Connection con = dbUtil.getConnection();
		// 실행할 SQL 문 작성하기
		String sql = "select no, title, writer, view_cnt from board order by no desc";
		// SQL 문을 실행할 객페를 얻어와야 함.
		PreparedStatement pstmt = con.prepareStatement(sql);

		// 실행할 SQL 문 실행하기 : select(excuteQuery), select절 이외 (excuteUpdate)
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int view_cnt = rs.getInt("view_cnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setViewCnt(view_cnt);
			list.add(board);
		}

		return list;
	}

	@Override
	public Board selectBoardByNo(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance(); // 디비에 접속 시켜주는 클래스
		Connection con = dbUtil.getConnection(); // 자바랑 디비랑 연결시켜주는 애

		String sql = "select no, title, writer, content, view_cnt from board where no = ?"; // 실행할 SQL 문 작성하기

		// SQL 문을 실행할 객페를 얻어와야 함.
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no); // 첫번째 물음표에 no를 넣는다는 뜻, 1이라는 뜻 아님.

		// 실행할 SQL 문 실행하기 : select(excuteQuery), select절 이외 (excuteUpdate)
		ResultSet rs = pstmt.executeQuery();

		// SQL 문을 실행 전에 ?에 값을 설정하자.

		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String content = rs.getString("content");
			int view_cnt = rs.getInt("view_cnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			board.setViewCnt(view_cnt);
			return board;
		}

		return null;

	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance(); // 디비에 접속 시켜주는 클래스
		Connection con = dbUtil.getConnection(); // 자바랑 디비랑 연결시켜주는 애

		String sql = "insert into board(title, writer, content) values(?, ?, ?)"; // 실행할 SQL 문 작성하기

		// SQL 문을 실행할 객페를 얻어와야 함.
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getTitle()); // 첫번째 물음표에 no를 넣는다는 뜻, 1이라는 뜻 아님.
		pstmt.setString(2, board.getWriter()); // 첫번째 물음표에 no를 넣는다는 뜻, 1이라는 뜻 아님.
		pstmt.setString(3, board.getContent()); // 첫번째 물음표에 no를 넣는다는 뜻, 1이라는 뜻 아님.
		pstmt.executeUpdate();
		// 실행할 SQL 문 실행하기 : select(excuteQuery), select절 이외 (excuteUpdate)
// 		ResultSet rs = pstmt.executeQuery(); // 조회할게 아니니까 실시할 필요가 없음. 

	}

	@Override
	public void deleteBoard(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance(); 
		Connection con = dbUtil.getConnection();
		
		String sql = "DELETE FROM board WHERE no = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		
		pstmt.executeUpdate();

	}

	@Override
	public void updateViewCnt(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();

		String sql = "UPDATE board SET view_cnt = view_cnt + 1  WHERE no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();

	}

	@Override
	public void editBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();

		String sql = "UPDATE board SET content = ?, title = ? WHERE no = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getContent());
		pstmt.setString(2, board.getTitle());
		pstmt.setInt(3, board.getNo());
		pstmt.executeUpdate();

	}

}
