package com.ssafy.myBoard.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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

//	@PostMapping("/write")
//	//attach 에 파일이 들어가 있음. 
//	public String write(@RequestParam("attach") MultipartFile attach, Board board) throws Exception {
//		// 작성한거 등록해줘야 함. 
//		String oriName = attach.getOriginalFilename();
//		if(oriName.length() > 0) { // 사용자가 파일을 선택했으면
//			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
//			File dir = new File("c:/SSAFY/uploads" + subDir); // 경로
//			dir.mkdir(); 
////			File f = new File(dir,UUID.randomUUID().toString() + oriName); // 앞에가 디렉토리에다가 파일 이름 합친거 
//			String systemName = UUID.randomUUID().toString() + oriName;
//			attach.transferTo(new File(dir,systemName)); // 메모리의 파일 정보를 특정 위치에 저장해주는 메서드
//			
//			//데이터 베이스에 저장하기 위한 준비
//			BoardFile boardFile = new BoardFile();
////			boardFile.setFileNo(0); // 데이터 입력시 자동 입력됨. 
//			boardFile.setFilePath(subDir); 
//			boardFile.setOriName(oriName);
//			boardFile.setSystemName(systemName);
//			boardFile.setNo(0); 		// board 테이블에 데이터가 입력되어야 입력할 수 있음. 
//			board.setBoardFile(boardFile);
//		
//		}
//		
//		boardService.writeBoard(board);
//		return "redirect:/board/list";
//	}

	@PostMapping("/write")
	public String write(@RequestParam("attach") MultipartFile attach, Board board) throws Exception {
		String oriName = attach.getOriginalFilename();
		if (oriName != null && oriName.length() > 0) { // 사용자가 파일을 선택했으면
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date(0));
			File dir = new File("c:/SSAFY/uploads" + subDir); // 경로
			String systemName = UUID.randomUUID().toString() + oriName;

			try {
				dir.mkdirs(); // 여러 단계의 디렉토리를 한 번에 생성
				File newFile = new File(dir, systemName);
				attach.transferTo(newFile);
				System.out.println("File created at: " + newFile.getAbsolutePath());

				// 데이터 베이스에 저장하기 위한 준비
				BoardFile boardFile = new BoardFile();
				boardFile.setFilePath(subDir);
				boardFile.setOriName(oriName);
				boardFile.setSystemName(systemName);
				boardFile.setNo(0); // board 테이블에 데이터가 입력되어야 입력할 수 있음.
				board.setBoardFile(boardFile);
			} catch (IOException e) {
				e.printStackTrace();
				// 로그 기록 또는 사용자에게 에러 메시지 전달
				return "error-page"; // 에러 페이지로 리다이렉트 또는 에러 메시지를 표시할 페이지
			}
		}

		boardService.writeBoard(board);
		return "redirect:/board/list";
	}

	// 생성자나 필드나 원하는 방식으로 가져오기
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/detail")
	public String detail( @RequestParam("no") int no, Model model) throws SQLException, IllegalStateException, IOException {
		System.out.println("no = " + no);
		Board board = boardService.detail(no);
		BoardFile file = board.getBoardFile();
		String filePath = file.getFilePath();
//		String filePath = boardFile.getFilePath();
//		model.addAttribute("filePath", filePath);
		System.out.println("file.getSystemName() : " + file.getSystemName());
		if (file != null && file.getSystemName().length() > 0) {
			String fileName = file.getSystemName();
			System.out.println("fileName :" + fileName);
			// 내가 만든 img 폴더를 가지고 오기
			// 스프링에서 파일이나 클래스 등 리소스를 로드할 땐 인터페이스인 리소스 로더가 있음.
//			Resource resource = resourceLoader.getResource("classpath:/static/img");

//			file.transferTo(new File(resource.getFile(), fileName));
			
			model.addAttribute("board", board);
			model.addAttribute("fileName", fileName);
			model.addAttribute("filePath", filePath);
		}
		return "/board/detail";

	}

}
