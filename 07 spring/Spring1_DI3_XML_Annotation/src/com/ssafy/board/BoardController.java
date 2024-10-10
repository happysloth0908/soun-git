package com.ssafy.board;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	private BoardService boardService;

	public void setBoardService (BoardService boardService) {
		this.boardService = boardService;
	}
	public void addBoard(String board) {
		boardService.addBoard(board);
	}
	
}
