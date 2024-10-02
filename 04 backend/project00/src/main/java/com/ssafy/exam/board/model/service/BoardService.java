package com.ssafy.exam.board.model.service;

import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardService {

	void delete(int review_id) throws Exception;

	Board detail(int review_id) throws Exception;

	List<Board> list() throws Exception;

	void write(Board board) throws Exception;

	void update(Board board) throws Exception;
}