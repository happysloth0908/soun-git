package com.ssafy.fitmate.review.model;

public class Review {
	/*
	review_id INT PRIMARY KEY,
    title VARCHAR(300) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    regTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id VARCHAR(100) NOT NULL,
    video_id INT NOT NULL,
    view_cnt INT 
	 */
	private int reviewId;
	private String title;
	private String content;
	private String regTime;
	private String userId;
	private String videoId;
	private int viewCnt;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, String title, String content, String regTime, String userId, String videoId,
			int viewCnt) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.content = content;
		this.regTime = regTime;
		this.userId = userId;
		this.videoId = videoId;
		this.viewCnt = viewCnt;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", title=" + title + ", content=" + content + ", regTime=" + regTime
				+ ", userId=" + userId + ", videoId=" + videoId + ", viewCnt=" + viewCnt + "]";
	}
}
