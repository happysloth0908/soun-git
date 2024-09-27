package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.repository.BoardRepository;
import com.ssafy.board.model.repository.BoardRepositoryImpl;

public class BoardServiceImpl implements BoardService {
// 싱글턴으로 관리 
	
	private static BoardService service = new BoardServiceImpl();
	
	private BoardRepository repo = BoardRepositoryImpl.getInstance();
	
	

	private BoardServiceImpl(){
	}

	public static BoardService getInstance() {
		return service;
		
	}
	
	@Override
	public List<Board> getList() {
		
		return repo.selectAll();
	}

	@Override
	public Board getBoard(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBoard(Board board) {
		repo.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub

	}

}
