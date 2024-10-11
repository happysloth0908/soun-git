package com.ssafy.board.model.service;

import java.sql.Date;

import com.ssafy.board.model.BoardDAO;

public class BoardServiceImpl implements BoardService{

	private final BoardDAO boardDao;
	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public void addBoard(String msg) {
//		System.out.println("Time : " + new Date().toLocaleString());
		System.out.println("서비스 addBoard 메서드 호출됨. ");
		boardDao.insert("AOP 정복 : " + msg);
	}

}
