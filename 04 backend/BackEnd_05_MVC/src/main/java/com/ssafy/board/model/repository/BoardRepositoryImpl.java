package com.ssafy.board.model.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Board;

public class BoardRepositoryImpl implements BoardRepository{

	
	private static BoardRepository repo = new BoardRepositoryImpl();

	
	// 메모리를 db 라 생각하고 관리하기 
//	private List<Board> list = new ArrayList<>();
	private Map<Integer, Board> boards = new HashMap<>();
	
	private BoardRepositoryImpl() {
		boards.put(0, new Board("가", "나","다"));
	}
	
	public static BoardRepository getInstance() {
		return repo;
	}
	
	@Override
	public List<Board> selectAll() {
		return (List<Board>)boards.values();
	}

	@Override
	public Board selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(Board board) {
		boards.put(board.getId(), board);
//		list.add(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		
	}

}
