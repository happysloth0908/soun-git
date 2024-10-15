package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/param")
public class O2Paramiter {
	
	@GetMapping("test2")
	//변수명에 해당하는 파라미터를 찾아줌. 없으면 오류남.  
//	public String test2(@RequestParam String id, @RequestParam String pass) { 
	// name은 파라미터가 올 수도 있고 안 올 수도 있어. 안 오면 null
//	public String test2(@RequestParam String id, @RequestParam String pass, @RequestParam(required = false) String name) { 
	// 파라미터 안 오면 null 이 아니라 default 로 설정한 값 들어감. 
	public String test2(@RequestParam String id, @RequestParam String pass, @RequestParam(required = false) String name, @RequestParam(defaultValue = "soun@naver.com") String email) { 
//	 파라미터 이름은 다르게 받고 싶어! password 로 온 파라미터를 pass 로 쓰겠어.
//	public String test2(@RequestParam(value = "password") String pass){ 
		
		
		System.out.println(id +" = id ," + pass + " = pass ," + name + " = name");
		return "param/index";
	}
	// id 가 key 값. "hong"이 value 값
	//@RequestParam 를 붙여야 map 에서 파라미터 값을 받음. 
	// 얘는 오류를 안 내서 뭐가 잘못됐는지 보기 어려움. 
	@GetMapping("test3")
	public String test3(@RequestParam Map<String, String> map) { 
		System.out.println(map.get("id") + "," + map.get("password"));
		return "param/index";
	}
	//이 방법을 제일 많이 씀 
	@GetMapping("test4")
	public String test4(User user) { 
		System.out.println(user);
		return "param/index";
	}
	
	@GetMapping("test1")
	public String test1(HttpServletRequest request ) { // 나 스프링 몰라요~~~
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(id +" = id ," + pass + " = pass");
		return "param/index";
	}
	
	
	@GetMapping("/index")
	public String index() {
		return "param/index";
	}
}
