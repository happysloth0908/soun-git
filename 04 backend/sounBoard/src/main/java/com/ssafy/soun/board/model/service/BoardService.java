package com.ssafy.soun.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.soun.board.model.dto.Board;

public interface BoardService {
	
	List<Board> getList() throws Exception;

	Board getBoardByNo(int no) throws Exception;

	void deleteBoard(int no) throws Exception;

}
