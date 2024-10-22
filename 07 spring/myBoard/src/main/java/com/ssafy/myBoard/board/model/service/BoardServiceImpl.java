package com.ssafy.myBoard.board.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.myBoard.board.model.BoardSearch;
import com.ssafy.myBoard.board.model.dao.BoardDao;
import com.ssafy.myBoard.board.model.dto.Board;
import com.ssafy.myBoard.board.model.dto.BoardFile;
import com.ssafy.util.PageResult;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, Object> list(BoardSearch boardsearch) {
		// 게시물 목록 데이터
		List<Board> list = boardDao.selectBoard(boardsearch);
		//페이징 처리를 위한 전체 게시물 카운트
		int totalCount = boardDao.selectBoardCount(boardsearch);
		int listSize = boardsearch.getListSize();
		PageResult pr = new PageResult(
				boardsearch.getPage(), 
				totalCount, 
				boardsearch.getListSize());
				

		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pr", pr);
		return result;
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
