package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardSearch;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, Object> getBoardList(BoardSearch boardSearch) {
		List<Board> boards = boardDao.selectAll(boardSearch);
		int totalCount = boardDao.selectBoardCount(boardSearch);
		int listSize = boardSearch.getListSize();
		int page = boardSearch.getPage();
		int startPage = page  / listSize * listSize + 1;
		if (page  % listSize == 0 ) {
			startPage = page  / listSize * listSize;
		}
		
		int lastPage = startPage + 9;
		if(lastPage * listSize > totalCount) {
			lastPage = (totalCount - 1) / listSize;
			if((totalCount - 1) % listSize > 0) {
				lastPage++;
			}
		}

		
		Map<String, Object> result = new HashMap();
		result.put("boards", boards);
		result.put("startPage", startPage);
		result.put("lastPage", lastPage);
		
		return result;
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id + "번 글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);

	}

	@Override
	public void removeBoard(int id) {
		System.out.println(id + "번 글 삭제합니다. ");
		boardDao.deleteBoard(id);
	}

	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition condition) {

		return boardDao.search(condition);
	}
	

}
