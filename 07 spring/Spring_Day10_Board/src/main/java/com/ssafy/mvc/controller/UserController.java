package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmpUser = userService.login(user.getId(), user.getPassword());
		//tmpUser : 정상로그인이면  user 정보 있고 비정상로그인이면 null
		if(tmpUser == null) {
			System.out.println("로그인 실패");
			return "redirect:login"; // 로그인 화면으로 보내기
		}
		session.setAttribute("loginUser", tmpUser.getName()); //000님 반갑습니다 를 위해
		return "redirect:list";
	}
	// 회원가입 따로 만들어보기 
	@GetMapping("/signup")
	public String signup() {
		return("/user/signupform");
	}
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);
		
		return "redirect:login";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		
		return "/user/adminPage";
	}
	
	
	
	
}
