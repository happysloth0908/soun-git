package com.ssafy.soun.board.model.dto;

public class Board {
	int no; //  글 번호
	int probNo; // 문제 번호
	String probName; // 문제 이름
	String source;  // 출처
	String writer; // 작성자
	String ans; // 풀이
	String time; // 작성시간
	int viewCnt; // 조회수
	
	public Board(){};
	
	public Board(int no, int probNo, String probName, String source, String writer, String ans, String time,
			int viewCnt) {
		super();
		this.no = no;
		this.probNo = probNo;
		this.probName = probName;
		this.source = source;
		this.writer = writer;
		this.ans = ans;
		this.time = time;
		this.viewCnt = viewCnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getProbNo() {
		return probNo;
	}
	public void setProbNo(int probNo) {
		this.probNo = probNo;
	}
	public String getProbName() {
		return probName;
	}
	public void setProbName(String probName) {
		this.probName = probName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", probNo=" + probNo + ", probName=" + probName + ", source=" + source + ", writer="
				+ writer + ", ans=" + ans + ", time=" + time + ", viewCnt=" + viewCnt + "]";
	}
	
	
	
	
}
