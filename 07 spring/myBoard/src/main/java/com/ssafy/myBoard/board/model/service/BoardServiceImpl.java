package com.ssafy.myBoard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myBoard.board.model.dao.BoardDao;
import com.ssafy.myBoard.board.model.dto.Board;
import com.ssafy.myBoard.board.model.dto.BoardFile;

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
	public Board detail(int no) {
		Board board = boardDao.getBoardByNo(no);
		board.setBoardFile(boardDao.selectBoardFileByNo(no));
		return board;
		
	}

	@Override
	public void writeBoard(Board board) throws SQLException {
		boardDao.insertBoard(board);
		BoardFile boardFile = board.getBoardFile();
		System.out.println("boardFile:" + boardFile);
		if(boardFile != null) { // 파일이 있으면 파일 넣기 
			boardFile.setNo(board.getNo());
			boardDao.insertBoardFile(boardFile);
		}
	}

	@Override
	public void deleteNo(int no) {
		boardDao.deleteBoard(no);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

}
