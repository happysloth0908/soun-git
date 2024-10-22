package com.ssafy.myBoard.board.model;

public class BoardSearch {
	private int page;
//	private int offset; // 건너뛸 보드 수 // 어차피 get 메서드로 계산하니까 멤버변수 필요없음. #{offset} = getOffset()
	private int listSize; // 보여줄 보드 수 
	
	public BoardSearch() {
//		this.page = 1; // 파라미터가 없이 오면 기본~!
//		this.listSize = 10;
		this(1,10);
	}
	
	public BoardSearch(int page) {
//		this.page = page; 
//		this.listSize = 10;
		this(page, 10);
	}
	public BoardSearch(int page, int listSize) {
		this.page = page; 
		this.listSize = listSize;
	}
//----------
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return (page -1) * listSize;
	}


	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	
}
