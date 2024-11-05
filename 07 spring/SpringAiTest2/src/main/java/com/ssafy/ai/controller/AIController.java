package com.ssafy.ai.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
public class AIController {
	
	//의존성 주입
	private final OpenAiChatModel openAiChatModel;	
	public AIController(OpenAiChatModel openAiChatModel) {
		this.openAiChatModel = openAiChatModel;
	}


	@GetMapping("/chatGPT") // 이름 자유임
	public ResponseEntity<String> chat(@RequestParam("message") String message) { // 메세지가 오면 지피티한테 전달해주려고 받음. 
		System.out.println(message);
		
		String response = openAiChatModel.call(message);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
