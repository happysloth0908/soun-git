package com.ssafy.music;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MusicTest {
	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("music-config.xml");
		Album album1 = (Album)ac.getBean("album");
		album1
		
	}
}
