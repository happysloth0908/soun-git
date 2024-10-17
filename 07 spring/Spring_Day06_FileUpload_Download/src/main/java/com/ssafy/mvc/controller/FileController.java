package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@GetMapping("/singleFileForm")
	public String singleForm() {
		return "singleFileForm";
	}

	// 생성자나 필드나 원하는 방식으로 가져오기
	@Autowired
	private ResourceLoader resourceLoader;

	@PostMapping("/singleFileUpload")
	// 파라미터 file 이 있으면 MultipartFile file 은 무조건 null 이 아님. 
	// 파라미터에 file 이 없으면 오류가 뜸. required = flase 를 설정하지 않았기 때문에 
	public String singleFileUpload(@RequestParam(value = "file", required = false) MultipartFile file, Model model) throws IOException {
//		System.out.println(file.getOriginalFilename());
		System.out.println(file);
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());
		
		System.out.println("singleFileUpload 메서드 호출됨. ");
		// 파일이 있는지 검사하기
		// 파일이 비어있으면 업로드 안 해줌.. 그럼 안 됨. 
//		if (file != null && file.getSize() > 0) {
		if (file != null && file.getOriginalFilename().length() > 0) {
			String fileName = file.getOriginalFilename();
			// 내가 만든 img 폴더를 가지고 오기
			// 스프링에서 파일이나 클래스 등 리소스를 로드할 땐 인터페이스인 리소스 로더가 있음.
			Resource resource = resourceLoader.getResource("classpath:/static/img");

			file.transferTo(new File(resource.getFile(), fileName));
			
			model.addAttribute("fileName", fileName);
		}

		return "result";
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		System.out.println("fileDownload 호출됨.");
		model.addAttribute("fileName", fileName);
		return "fileDownloadView"; // 그럼 FileDownloadView 클래스로 감. 걔는 fileDownloadView로 빈 등록되어 있으니까
	}
	
	@GetMapping("/multiFileForm")
	public String multiForm() {
		return "multiFileForm";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files, Model model) throws IOException {
		for( MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		return "result";
	}
	
}
