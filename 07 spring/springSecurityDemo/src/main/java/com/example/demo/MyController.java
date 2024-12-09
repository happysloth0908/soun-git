package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {
	@GetMapping("/")
	public String getMethodName(HttpServletRequest request) {
		return "당신의 세션 아이디는: " + request.getSession().getId();
	}
	

}
