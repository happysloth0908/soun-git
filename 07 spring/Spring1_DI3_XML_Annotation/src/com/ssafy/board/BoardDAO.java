package com.ssafy.board;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO {

	void insertBoard(String board);
}
