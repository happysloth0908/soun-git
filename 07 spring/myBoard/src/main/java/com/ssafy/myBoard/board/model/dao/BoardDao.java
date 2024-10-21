package com.ssafy.myBoard.board.model.dao;

import java.util.List;

import com.ssafy.myBoard.board.model.dto.Board;
import com.ssafy.myBoard.board.model.dto.BoardFile;

public interface BoardDao {

	List<Board> selectBoard();

	Board getBoardByNo(int no) ;

	void insertBoardFile(BoardFile boardFile) ;

	void insertBoard(Board board) ;

	BoardFile selectBoardFileByNo(int no);

	void deleteBoard(int no);

	void updateBoard(Board board);

}
