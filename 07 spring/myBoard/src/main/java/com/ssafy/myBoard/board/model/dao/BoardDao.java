package com.ssafy.myBoard.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myBoard.board.model.Board;

public interface BoardDao {

	List<Board> selectBoard() throws SQLException;

	void registBoard(Board board) throws SQLException;

	Board getBoardByNo(int no) throws SQLException;

}
