package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssafy.mvc.model.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	// 정석으로는 이제 service 의존성 주입 받아야 함. 
//	@Autowired
//	private UserService userService;
//
//	public UserController(UserService userService) {
//		this.userService = userService;
//		
//	}
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		
		System.out.println(id);
		System.out.println(pw);
		return "hello";
	}
	
	
	
	
	
	
	
	

	
}
