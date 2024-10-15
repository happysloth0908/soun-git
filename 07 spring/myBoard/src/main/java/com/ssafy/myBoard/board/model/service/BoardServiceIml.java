package com.ssafy.myBoard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.dao.BoardDao;

@Service
public class BoardServiceIml implements BoardService{

	private final BoardDao boardDao;
	public BoardServiceIml(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> list() throws Exception {
		
		return boardDao.selectBoard();
	}

	@Override
	public void write(Board board) throws Exception {
		boardDao.registBoard(board);
	}

	@Override
	public Board getBoardByno(int no) throws SQLException {
		return boardDao.getBoardByNo(no);
	}

}
