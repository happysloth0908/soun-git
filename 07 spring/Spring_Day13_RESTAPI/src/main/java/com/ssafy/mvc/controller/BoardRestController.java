package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController 
@RequestMapping("/api-board")
@Tag(name = "BoardRestful API", description = "게시판 CRUD")
public class BoardRestController {

	private final BoardService boardService;

	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 게시글 전체조회
	@GetMapping("/board")
	public ResponseEntity<List<Board>> list() {
		List<Board> list = boardService.getBoardList();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*"); // 지금은 일단 다 * 허용
		
		
		return new ResponseEntity<>(list, headers, HttpStatus.OK);
//		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> deatil(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id);
		System.out.println(board);
		if (board != null) {
			return ResponseEntity.ok(board);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
//	게시글 등록 (form 데이터 형식으로 넘어왔다고 가정)
//	@PostMapping("/board")
//	public ResponseEntity<?> write(@ModelAttribute Board board) {
//		boardService.writeBoard(board);
//		int id = board.getId();
//		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
//	}
	
	//게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		boolean isDeleted = boardService.removeBoard(id);
		if (isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	//게시글 수정
	@PutMapping("board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id,@RequestBody Board board) {
		board.setId(id);
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//검색
//	@GetMapping("/board")
//	@Operation(summary = "게시글 검색 및 조회", description = "조건에 따른 검색을 수행할 수 있음")
//	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
//		System.out.println(condition);
//		List<Board> list = boardService.search(condition);
//		
//		if(list == null || list.size() == 0) {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//	}
//	
	//파일 업로드
	@PostMapping("/board") //form 형태
	public ResponseEntity<Void> fileUpload(@RequestParam("file") MultipartFile file, @ModelAttribute Board board){
		System.out.println(file.getOriginalFilename());
//		System.out.println(board);
		boardService.fileUpload(file, board);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	// 다운로드 해야 하는데 뷰는 못 받아옴.. @RestController 때문에.. 그래서 컨트롤러 새로 만듦. 

}