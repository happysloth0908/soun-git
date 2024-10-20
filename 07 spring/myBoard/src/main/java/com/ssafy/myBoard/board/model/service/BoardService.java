package com.ssafy.myBoard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myBoard.board.model.dto.Board;

public interface BoardService {
	List<Board> list() throws Exception;

//	void write(Board board) throws Exception;

//	Board getBoardByno(int no) throws SQLException;

	Board detail(int no);

	void writeBoard(Board board) throws SQLException;

	void deleteNo(int no);

	void updateBoard(Board board);
	

}
