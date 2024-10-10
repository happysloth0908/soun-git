package com.ssafy.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("board-config.xml");
		String[] names = ac.getBeanDefinitionNames();
		for ( String name : names) {
			System.out.println(name);
		}
		BoardController controller = ac.getBean("boardController", BoardController.class);
		controller.addBoard("게시판 등록입니다.");
	}
}	
