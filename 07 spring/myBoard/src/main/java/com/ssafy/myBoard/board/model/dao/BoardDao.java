package com.ssafy.myBoard.board.model.dao;

import java.util.List;

import com.ssafy.myBoard.board.model.BoardSearch;
import com.ssafy.myBoard.board.model.dto.Board;
import com.ssafy.myBoard.board.model.dto.BoardFile;

public interface BoardDao {
	

	Board getBoardByNo(int no) ;

	void insertBoardFile(BoardFile boardFile) ;

	void insertBoard(Board board) ;

	BoardFile selectBoardFileByNo(int no);

	void deleteBoard(int no);

	void updateBoard(Board board);
	
	List<Board> selectBoard(BoardSearch boardSearch);
	// 게시물 페이징 처리를 위한 전체 데이터 카운트
	int selectBoardCount(BoardSearch boardsearch);

}
