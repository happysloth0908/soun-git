package com.ssafy.movie;

public class Movie {
	private Director director;
	
	public Movie(Director director) {
		this.director = director;
	}
	public void display() {
		System.out.println("영화 감도ㅇ: " + director.getName());
	}
}
