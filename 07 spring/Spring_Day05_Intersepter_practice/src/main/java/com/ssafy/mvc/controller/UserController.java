package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	

	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String id, @RequestParam String pw, HttpSession session) throws Exception{
		//있는 아이디와 비번인지 확인하기

		
		String name = userService.checkIdPass(id, pw);
//		model.addAttribute("name" , name);
		session.setAttribute("name", name);
		System.out.println("name = " + name);
		// 돌아온 값이 null 이면 다시 로그인 창으로 봰기 
		// 돌아온 값이 true 면 다시 메인으로 보내고 로그아웃 보이게 하기 
		if(name == null) {
			return "user/loginForm";
		}else {
			
			return "hello";
		}
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "hello";
		
	}
	
}
