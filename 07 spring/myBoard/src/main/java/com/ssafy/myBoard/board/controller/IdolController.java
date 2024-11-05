package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/*
<a href="~~">이동</a>
<form method="get | post">
REST 
GET : 조회
/idol/list		-> GET  	  /idol
/idol/detail	-> GET  	  /idol/100
/idol/write		-> POST 	  /idol			{"name": "홍길동", "gender": "F"}
/idol/update	-> PUT, PATCH /idol/100    	{"no": 100, "name": "홍길동", "gender": "F"}
/idol/delete	-> DELETE	  /idol/100
*/

//@Controller
@RestController
@RequestMapping("/api/idol")
@Tag(
		name="IdolController(아이돌 관리 컨트롤러)", 
		description = "아이돌 정보를 처리하는 컨트롤러 클래스입니다."
)
@CrossOrigin
public class IdolController {
	private final IdolService idolService;
	public IdolController(IdolService idolService) {
		this.idolService = idolService;
	}

	/*
200 HTTP/1.1 OK
connection: keep-alive
content-type: application/json
date: Thu, 24 Oct 2024 02:39:40 GMT
keep-alive: timeout=60
transfer-encoding: chunked

[{"no":2,"name":"차은우","gender":"M"},{"no":1,"name":"로제","gender":"F"}]

	 * 
	 * 
	 * 응답
	 * 시작라인(200 HTTP/1.1 OK) 
	 * 헤더   키:값
	 *       키:값
	 * 빈줄~
	 * 바디
	 * 
	 * 200 HTTP/1.1 OK
	 * a:1
	 * b:1
	 * c:2
	 * 
	 * d:3
	 * 
	 * 
	 * JSON
	 * 맵 : {}
	 * DTO : {}
	 * LIST, 배열 : []
	 * 
	 * [
	 * {
	 * 	  "no": 100,
	 *    "name": "홍길동",
	 *    "gender": "F"
	 * }, {}]
	 */
	@GetMapping
//	@ResponseBody
	/*
		    성공시 : 200
			데이터가 없는 경우 : 204
			실패시 : 500
	 */
	// 응답 코드 : 200
	// 응답 바디 : List<Idol>
	@Operation(
			summary = "아이돌 전체 목록 조회",
			description = "모든 아이돌 목록을 반환합니다.",
			responses = {
				@ApiResponse(responseCode = "200", description = "조회 성공"),	
				@ApiResponse(responseCode = "204", description = "조회된 데이터가 없음"),	
				@ApiResponse(responseCode = "500", description = "서버 실행시 에러")	
			}
	)
	public ResponseEntity<Object> list() {
		ResponseEntity<Object> responseEntity;
		try {
			List<Idol> list = idolService.list();
			if (list.isEmpty()) {
				responseEntity = new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
			} else {
				HttpHeaders headers = new HttpHeaders();
				headers.add("mykey", "abcde12345");
				responseEntity = new ResponseEntity<>(list, headers, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(
					"문제가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
		
//	public Map<String, Object> list() {
		// list 데이터를 브라우져에서 사용하도록 문자열로 변환해서 전송해줘야 한다.
		// 객체를 반환하면 객체의 내용을 JSON으로 자동 변환 : JACKSON
		
		/*
		 * 1000 : 정상 처리
		 * 1001 : 서버 문제 발생 
		 * 1002 : 요청 정보가 잘못되었음 
		
		 */
//		Map<String, Object> result = new HashMap<>();
//		result.put("code", 1002);		
//		result.put("message", idolService.list());
//		return result;
		

	}
	
	/*
	 	정상일 경우 200
	 	요청 번호에 해당하는 데이터가 없을 경우 204
	 */
	// /idol/76
	@GetMapping("{no}")
//	@ResponseBody
	@Operation(
//			hidden = true,
			summary = "아이돌 상세 조회",
			description = "번호에 해당하는 아이돌의 상세 정보를 반환합니다.",
			responses = {
					@ApiResponse(responseCode = "200", description = "정상 조회"),
					@ApiResponse(responseCode = "204", description = "데이터가 존재하지 않음")
			},
			parameters = {
					@Parameter(
							name = "no", 
							description = "아이돌 번호",
							required = true	
					)
			}
	)
//	@Hidden
	public ResponseEntity<Idol> detail(@PathVariable("no") int no) {
//	public Idol detail(@PathVariable int no) {
		Idol idol = idolService.detail(no);
		if (idol == null) {  // 요청 번호에 해당하는 아이돌이 존재하지 않는 경우
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(idol);
//		return ResponseEntity.ok(idol);

		// 기존 객체 생성 방식
//		return new ResponseEntity<Idol>(idol, HttpStatus.OK);
	}
	
	// /idol/100
	@DeleteMapping("{no}")
	public void remove(@PathVariable("no") int no) {
		idolService.remove(no);
//		return ResponseEntity.ok().build();
//		return ResponseEntity.status(HttpStatus.OK).build();
//		return ResponseEntity.status(HttpStatus.OK).body("hello");
	}
	
	// 등록
	@PostMapping
	public void regist(@RequestBody Idol idol) {
		idolService.regist(idol);
	}
	
	// 수정
	@PutMapping("{no}")
	public void modify(@PathVariable("no") int no, @RequestBody Idol idol) {
		System.out.println("수정");
		idol.setNo(no);
		idolService.modify(idol);
	}
}












