package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api-user")
public class UserRestController {

	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	// 사용자 목록 전체 가져오기 
	@GetMapping("/users")
	public ResponseEntity<List<User>> userList(@RequestParam String param) {
		// 사람 없으면 204
		return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
	}
	// 사용자 회원가입
	@PostMapping("/signup")
	public String postMethodName(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
	//로그인 
//	@PostMapping("/login")
//	public String postMethodName(@RequestBody User, HttpSession session) {
//		//TODO: process POST request
//		
//		return HttpSession sessoin;
//	}
//	
//	//로그아웃
	
	

}
