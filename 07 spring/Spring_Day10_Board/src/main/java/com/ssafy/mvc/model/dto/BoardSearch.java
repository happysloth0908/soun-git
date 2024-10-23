package com.ssafy.mvc.model.dto;

public class BoardSearch {
	private int page;
	private int listSize;

	public BoardSearch() {
		this(1, 10);
	}

	private BoardSearch(int page) {
		this(page, 10);
	}

	private BoardSearch(int page, int listSize) {
		this.page = page;
		this.listSize = listSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public int getListSize() {
		return listSize;
	}

	public int getOffset() {
		return (page - 1 ) * listSize; 
	}

	@Override
	public String toString() {
		return "BoardSearch [page=" + page + ", listSize=" + listSize + "]";
	}

}
