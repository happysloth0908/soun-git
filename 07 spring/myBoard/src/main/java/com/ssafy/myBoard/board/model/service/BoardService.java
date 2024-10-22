package com.ssafy.myBoard.board.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.myBoard.board.model.BoardSearch;
import com.ssafy.myBoard.board.model.dto.Board;

public interface BoardService {

//	void write(Board board) throws Exception;

//	Board getBoardByno(int no) throws SQLException;

	Board detail(int no);

	void writeBoard(Board board) throws SQLException;

	void deleteNo(int no);

	void updateBoard(Board board);

	Map<String, Object> list(BoardSearch boardsearch);
	

}
