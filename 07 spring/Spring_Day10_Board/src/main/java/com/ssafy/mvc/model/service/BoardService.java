package com.ssafy.mvc.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardSearch;
import com.ssafy.mvc.model.dto.SearchCondition;



public interface BoardService {
	// 게시글 전체 조회
	public Map<String, Object> getBoardList(BoardSearch boardSearch);

	// 게시글 상세조회 (클릭시 읽는거)
	public Board readBoard(int id);

	// 게시글 작성
	public void writeBoard(Board board);

	// 게시글 삭제
	public void removeBoard(int id);

	// 게시글 수정
	public void modifyBoard(Board board);
	// 검색 버튼을 눌렀을 때 처리할 메서드
	public List<Board> search(SearchCondition condition);
}