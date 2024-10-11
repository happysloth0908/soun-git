package com.ssafy.board.model;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Override
	public void insert(String msg) {
		System.out.println("게시물 등록 : " + msg);
	}

}
