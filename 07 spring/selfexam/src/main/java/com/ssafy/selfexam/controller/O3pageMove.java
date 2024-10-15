package com.ssafy.selfexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pagemove")
public class O3pageMove {

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", "Hey~ 아임 마델");
//		mav.setViewName("pagemove/index"); // 뷰 이름에 따라 jsp 가져옴. 
//		return mav;
		
		return new ModelAndView("pagemove,index");
	}
//	@GetMapping("/index")
//	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView();
//		return new ModelAndView("pagemove,index");
//	}
//	
	//	@GetMapping("/index")
//	public String index() {
//		return "pagemove/index";
//	}
	// 예전엔 이렇게도 씀. 왜냐면 주소가 같으니까 추론이 가능하잖슴. 호출하는 Url 그 자체가 이동하려는 jsp 의 주소임. 
//	@GetMapping("/index")
//	public void index() {	}
}
