package com.ssafy.prj.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.prj.board.model.dto.Board;

public interface BoardDAO {

	void insertBoard(Board board) throws SQLException;

	List<Board> selectBoard(String video_id) throws SQLException;

	Board selectBoardByReview_id(int review_id)  throws SQLException;

	void deleteBoard(int review_id)  throws SQLException;

	void updateViewCnt(int review_id)  throws SQLException; 

	void updateBoard(Board board)  throws SQLException;

}