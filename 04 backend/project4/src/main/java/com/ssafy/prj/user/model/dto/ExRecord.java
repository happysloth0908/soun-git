package com.ssafy.prj.user.model.dto;

public class ExRecord {
	private String part;
	private String exDate;
	private int exTime;
	private String userId;

	public ExRecord(String part, String exDate, int exTime, String userId) {
		super();
		this.part = part;
		this.exDate = exDate;
		this.exTime = exTime;
		this.userId = userId;
	}



	public ExRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getExDate() {
		return exDate;
	}
	public void setExDate(String exDate) {
		this.exDate = exDate;
	}
	public int getExTime() {
		return exTime;
	}
	public void setExTime(int exTime) {
		this.exTime = exTime;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ExRecord [exDate=" + exDate + ", exTime=" + exTime + ", part=" + part + ", userId=" + userId + "]";
	}
	
	
}
