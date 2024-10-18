package com.ssafy.myBoard.board.model.dao;

import java.util.List;

import com.ssafy.myBoard.board.model.Board;
import com.ssafy.myBoard.board.model.BoardFile;

public interface BoardDao {

	List<Board> selectBoard();

//	void registBoard(Board board) ;

	Board getBoardByNo(int no) ;

	void insertBoardFile(BoardFile boardFile) ;

	void insertBoard(Board board) ;

	BoardFile selectBoardFileByNo(int no);

//	Board selectBoardByNo(int no);


}
