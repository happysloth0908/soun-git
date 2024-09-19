package com.ssafy.ws.step2.dto;

public class Movie {
	private int id;
	private String tittle;
	private String director;
	private String genre;
	private String runningTime;
	
	public Movie(int id, String tittle, String director, String genre, String runningTime) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", 제목=" + tittle + ", 감독=" + director + ", 장르=" + genre
				+ ", 상영시간=" + runningTime + "]";
	}
	
	
}
