package com.ssafy.mvc.model.dto;

public class BoardFile{
	private int id;
	private int fileId;
	private String oriName;
	private String filePath;
	private String SystemName;
	
	public int getNo() {
		return id;
	}
	public void setNo(int no) {
		this.id = no;
	}
	public int getFileNo() {
		return fileId;
	}
	public void setFileNo(int fileNo) {
		this.fileId = fileNo;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSystemName() {
		return SystemName;
	}
	public void setSystemName(String systemName) {
		SystemName = systemName;
	}
	public BoardFile(int no, int fileNo, String oriName, String filePath, String systemName) {
		super();
		this.id = no;
		this.fileId = fileNo;
		this.oriName = oriName;
		this.filePath = filePath;
		SystemName = systemName;
	}
	
	BoardFile(){}
	@Override
	public String toString() {
		return "BoardFile [id=" + id + ", fileNo=" + fileId + ", oriName=" + oriName + ", filePath=" + filePath
				+ ", SystemName=" + SystemName + "]";
	}
	
	
}
