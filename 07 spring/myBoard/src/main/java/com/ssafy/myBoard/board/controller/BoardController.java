package com.ssafy.myBoard.board.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.BoardFile;
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
	//attach 에 파일이 들어가 있음. 
	public String write(@RequestParam("attach") MultipartFile attach, Board board) throws Exception {
		// 작성한거 등록해줘야 함. 
		String oriName = attach.getOriginalFilename();
		if(oriName.length() > 0) { // 사용자가 파일을 선택했으면
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
			File dir = new File("c:/ssafy/uploads" + subDir); // 경로
			dir.mkdir(); 
//			File f = new File(dir,UUID.randomUUID().toString() + oriName); // 앞에가 디렉토리에다가 파일 이름 합친거 
			String systemName = UUID.randomUUID().toString() + oriName;
			attach.transferTo(new File(dir,systemName)); // 메모리의 파일 정보를 특정 위치에 저장해주는 메서드
			
			//데이터 베이스에 저장하기 위한 준비
			BoardFile boardFile = new BoardFile();
//			boardFile.setFileNo(0); // 데이터 입력시 자동 입력됨. 
			boardFile.setFilePath(subDir); 
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
//			boardFile.setNo(); 		// board 테이블에 데이터가 입력되어야 입력할 수 있음. 
			board.setBoardFile(boardFile);
		
		}
		
		boardService.writeBoard(board);
		return "redirect:/board/list";
	}
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) throws SQLException {
		System.out.println("no = " + no);
		Board board = boardService.detail(no);
		model.addAttribute("board", board);
		return "/board/detail";
		
	}
	
}
