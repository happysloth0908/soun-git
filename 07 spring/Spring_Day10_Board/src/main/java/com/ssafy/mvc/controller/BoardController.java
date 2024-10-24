package com.ssafy.mvc.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardFile;
import com.ssafy.mvc.model.dto.BoardSearch;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

@Controller
//@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;

	// @QutoWired 안 써도 됨. 생성자가 하나라
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/list")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model,
			BoardSearch boardSearch) {
		// 서비스를 통해 게시글 가져와야 함~!
		if (page != 1) {
			boardSearch.setPage(page);
		}
		Map<String, Object> result = boardService.getBoardList(boardSearch);
		boolean prev = true;
		if (page == 1)
			prev = false;
		model.addAttribute("prev", prev);
		model.addAttribute("boards", result.get("boards"));
		model.addAttribute("lastPage", result.get("lastPage"));
		model.addAttribute("startPage", result.get("startPage"));
		model.addAttribute("endPage", result.get("endPage"));
		return "/board/list";
	}

	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}

	@PostMapping("/write")
	public String write(Board board, @RequestParam("attach") MultipartFile attach) {
		String oriName = attach.getOriginalFilename();
		if (oriName != null) {
			String subDir = new SimpleDateFormat("/YYYY/MM/DD/HH").format(new Date()); // 경로에 붙일거 만들기
			File dir = new File("c:/SSAFY/album" + subDir); // 경로 만들기
			String systemName = UUID.randomUUID().toString().toString() + oriName; // 고유한 파일 이름 만들어주기

			try {
				dir.mkdir(); // 경로 만들어주기
				File newFile = new File(dir, systemName); // 경로와 파일 이름 넣어주고 파일 만들기
				attach.transferTo(newFile); // 만들어준 파일에 받은 사진/텍스트 자료 넣어주기
				System.out.println("File created at: " + newFile.getAbsolutePath()); // 확인 출력

				// 이제 BoardFile 형식으로 담아서 코드내로 왔다갔다 할 수 있도록 하기
				BoardFile boardFile = new BoardFile();
				boardFile.setFilePath(subDir);
				boardFile.setOriName(oriName);
				boardFile.setSystemName(systemName);
				boardFile.setNo(0); // 일단 임시값 주기.. 보드 테이블에 값이 들어가야 제대로 입력 가능
				board.setBoardFile(boardFile);
			} catch (Exception e) {
				e.printStackTrace();
				return "/errorPage"; // 에러 페이지 만들기
			}
		}
		// 엉..? 근데 보드 파일은 안 쓰나...?
		boardService.writeBoard(board);

		return "redirect:list";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}

	// POST 로 해보면 가산점
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
