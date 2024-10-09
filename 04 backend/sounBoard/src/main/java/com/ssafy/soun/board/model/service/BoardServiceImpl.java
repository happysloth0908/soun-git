package com.ssafy.soun.board.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.soun.board.model.dao.BoardRepository;
import com.ssafy.soun.board.model.dao.BoardRepositoryImpl;
import com.ssafy.soun.board.model.dto.Board;

public class BoardServiceImpl implements BoardService{
	
	// boardDAO 또는 boardRepository에서 객체 가져오기
	private BoardRepository br;
	private BoardServiceImpl(){
		br = BoardRepositoryImpl.getInstance();
	}
	
	// boardController 에서 불러줄 수 있는 인스턴스 만들기
	private static BoardService instance = new BoardServiceImpl();
	public static BoardService getInstance() {
		return instance;
	}
	
	public List<Board> getList() throws Exception{
		List<Board> list = new ArrayList<>();
		list = br.getList();
		return list;
		
	}

	@Override
	public Board getBoardByNo(int no) throws Exception {
		br.updateViewCnt(no); // 조회수 올리기
		return br.getBoardByNo(no);
	}

	@Override
	public void deleteBoard(int no) throws Exception {
		br.deleteBoard(no);
	}
	
	
	
}
