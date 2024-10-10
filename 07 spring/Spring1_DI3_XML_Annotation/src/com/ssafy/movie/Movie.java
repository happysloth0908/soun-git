package com.ssafy.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Movie {
//	@Autowired
	private final Director director;
	public void display() {
		System.out.println("영화 감도ㅇ: " + director.getName());
	}
}
