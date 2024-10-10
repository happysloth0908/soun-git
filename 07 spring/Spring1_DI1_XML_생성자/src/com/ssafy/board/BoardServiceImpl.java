package com.ssafy.board;

public class BoardServiceImpl implements BoardService{
	private BoardDAO boardDao;

	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDao = boardDAO;
	}

	@Override
	public void addBoard(String board) {
		boardDao.insertBoard(board);
	}
	
	
	
}
