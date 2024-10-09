package com.ssafy.prj.video.model.dto;

public class Video {
	private String video_id;
	private String title;
	private String src;
	private String part;
	private int view_cnt;
	private String channel;
	
	
	public Video() {
	}

	public Video(String video_id, String title, String src, String part, int view_cnt, String channel) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.src = src;
		this.part = part;
		this.view_cnt = view_cnt;
		this.channel = channel;
	}

	public String getVideo_id() {
		return video_id;
	}


	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}


	public String getPart() {
		return part;
	}


	public void setPart(String part) {
		this.part = part;
	}


	public int getView_cnt() {
		return view_cnt;
	}


	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", title=" + title + ", src=" + src + ", part=" + part + ", view_cnt="
				+ view_cnt + ", channel=" + channel + "]";
	}
	
}
