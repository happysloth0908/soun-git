package com.ssafy.myBoard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.BoardFile;
import com.ssafy.myBoard.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectBoard();
	}

	@Override
	public Board detail(int no) throws SQLException {
		Board board = boardDao.getBoardByNo(no);
		board.setBoardFile(boardDao.getBoardByNo(no));
		return board;
		
	}

	@Override
	public void writeBoard(Board board) throws SQLException {
		boardDao.insertBoard(board);
		BoardFile boardFile = board.getBoardFile();
		boardFile.setNo(board.getNo());
		boardDao.insertBoardFile(boardFile);
	}
}
