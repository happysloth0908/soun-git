package com.ssafy.prj.board.model.dto;

public class Board {
	int review_id;
	String title;
	String content;
	String regTime;
	String video_id;
	String user_id;
	int view_cnt;

	
	public Board(){}


	public Board(int review_id, String title, String content, String regTime, String video_id, String user_id,
			int view_cnt) {
		super();
		this.review_id = review_id;
		this.title = title;
		this.content = content;
		this.regTime = regTime;
		this.video_id = video_id;
		this.user_id = user_id;
		this.view_cnt = view_cnt;
	}


	public int getReview_id() {
		return review_id;
	}


	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegTime() {
		return regTime;
	}


	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}


	public String getVideo_id() {
		return video_id;
	}


	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public int getView_cnt() {
		return view_cnt;
	}


	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}


	@Override
	public String toString() {
		return "Board [review_id=" + review_id + ", title=" + title + ", content=" + content + ", regTime=" + regTime
				+ ", video_id=" + video_id + ", user_id=" + user_id + ", view_cnt=" + view_cnt + "]";
	}

	
	
	
	
}
