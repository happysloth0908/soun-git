package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/share")
public class O4share {
	// prefix suffix
	@GetMapping("/index")
	public void index() {}
	
	//스프링의 특징: 객체를 자동으로 페이지에 공유해줌. 
	@GetMapping("/test1")
	public String test1(@ModelAttribute("u") User u) {
		System.out.println("user :" + u);
		return "share/index";
	}
	// 쌤 개인적으로 가장 많이 쓰는 것
	// 모델 선언 후 내가 담고 싶은 내용 model 객체에 넣기
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("msg", "공유1");
		model.addAttribute("hi", "인사1");
		return "share/index";
	}
	
	@GetMapping("/test3")
	public String test3(Map<String, String> map) {
		map.put("msg", "맵공유1");
		map.put("hi", "맵인사1");
		return "share/index";
	}
}
