package com.ssafy.music;

public class Album {
	Artist artist;
	
	//외부에서 아티스트 이름을 넣주면 앨범에 넣기 
	public void Album(Artist artist){
		this.artist = artist;
	}
	
}