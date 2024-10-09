package com.ssafy.soun.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.soun.board.model.dto.Board;

public interface BoardRepository {

	List<Board> getList() throws Exception;

	Board getBoardByNo(int no) throws Exception;
	
	void updateViewCnt(int no) throws Exception;

	void deleteBoard(int no) throws Exception;
	
}
