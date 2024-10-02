package com.ssafy.exam.board.model.service;

import java.util.List;

import com.ssafy.exam.board.model.dao.BoardDAO;
import com.ssafy.exam.board.model.dao.BoardDAOImpl;
import com.ssafy.exam.board.model.dto.Board;

public class BoardServiceImpl implements BoardService {

	public BoardDAO boardDao;

	private static BoardService boardService = new BoardServiceImpl();
	public BoardServiceImpl() {
		boardDao = BoardDAOImpl.getInstance();
	}
	public static BoardService getInstance() {
		return boardService;
	}
	
	@Override
	public void delete(int review_id) throws Exception  {
		boardDao.deleteBoard(review_id);
	}

	@Override
	public Board detail(int review_id) throws Exception {
		boardDao.updateViewCnt(review_id);
		Board board = boardDao.selectBoardByReview_id(review_id);
		return board;
	}

	@Override
	public List<Board> list() throws Exception {
		List<Board> list =  boardDao.selectBoard();
		return list;
	}
	
	@Override
	public void write(Board board) throws Exception {
		boardDao.insertBoard(board);
	}
	@Override
	public void update(Board board) throws Exception {
		
		
	}


	
}








