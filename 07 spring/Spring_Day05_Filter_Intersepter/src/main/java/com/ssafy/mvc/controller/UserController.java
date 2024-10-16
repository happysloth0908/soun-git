package com.ssafy.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/user")
public class UserController {

	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
}
