package com.ssafy.myBoard.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService; // 생성자에서 받겠다는 소리임 final
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
//		List<Board> list = boardService.list();
//		model.addAttribute("list", list);
		model.addAttribute("list", boardService.list());
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	
	@PostMapping("/write")
	public String write(Board board) throws Exception {
		// 작성한거 등록해줘야 함. 
		boardService.write(board);
		return "redirect : /list";
	}
}
