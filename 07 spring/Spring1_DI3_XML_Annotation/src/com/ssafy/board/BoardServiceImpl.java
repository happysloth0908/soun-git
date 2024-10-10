package com.ssafy.board;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	private BoardDAO boardDao;

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void addBoard(String board) {
		boardDao.insertBoard(board);
	}
	
	
	
}
