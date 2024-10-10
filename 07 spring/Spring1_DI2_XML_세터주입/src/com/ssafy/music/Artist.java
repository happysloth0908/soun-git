package com.ssafy.music;

public class Artist {
	String artistName;
	
	// 외부에서 이름을 받으면 그걸로 입력할 수 있도록 설정
	public Artist(String artistName) {
		this.artistName = artistName;
	}
	
	public String getArtistName(){
		return artistName;
	}
}
