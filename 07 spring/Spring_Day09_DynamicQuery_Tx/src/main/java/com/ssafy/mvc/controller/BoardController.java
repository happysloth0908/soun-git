package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BoardController {
	private BoardService boardService;
	
	// @QutoWired 안 써도 됨. 생성자가 하나라 
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		//서비스를 통해 게시글 가져와야 함~!
		List<Board> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		return "/board/list";
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model ) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	//POST 로 해보면 가산점
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		return "redirect:list"; // view resolver 한테 list 찾아와~!
//		return "/board/list"; // url에 적고 다시 컨트롤러의 list 메서드한테 감. 
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id") int id, Model model) {
		// 근데 이렇게 하면 게시글 조회수 올라감... 그냥 쌩으로 가져오는 방법 가져와야 함. 
		model.addAttribute("board", boardService.readBoard(id));
		
		return "/board/updateform";
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id=" + board.getId();
	}
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCondition condition, Model model) {
		model.addAttribute("boards", boardService.search(condition));
		return "/board/list";
	}
	
	
	
}
