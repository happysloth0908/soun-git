package com.ssafy.mvc.controller;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileController {
//	private final ResourceLoader resourceLoader;
//	public FileController(ResourceLoader resourceLoader) {
//		this.resourceLoader = resourceLoader;
//	}
	
	@GetMapping("/download") // name 이 아니라 사실은  fileId 임.. 
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView"; // 이게 뭐지...? 
	}
	
	

}
