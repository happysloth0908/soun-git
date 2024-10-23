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
		int totalCount = boardDao.selectBoardCount(boardSearch);// 총 글의 수
		int listSize = boardSearch.getListSize(); // 글을 몇 개씩 보여줄지
		int page = boardSearch.getPage(); // 해당 글이 몇번째 page 에 있는지
		int barSize = 10; // 밑에 있는 페이지 버튼 길이
		int startPage = page  / barSize * barSize + 1; // 페이지 버튼 중 시작 숫자
		if (page  % barSize == 0 ) { // 페이지 버튼의 길이가 마지막 글을 초과해서 생기지 않도록
			startPage = page  / barSize * barSize;
		}
		
		int lastPage = startPage + 9; // 페이지 버튼 중 마지막 숫자
		if(lastPage * barSize > totalCount) { // 글이 남아있으면 한 장 더 생기도록
			lastPage = (totalCount - 1) / listSize;
			if((totalCount - 1) % listSize > 0) {
				lastPage++;
			}
		}
		int endPage = (totalCount - 1 ) / barSize;
		if((totalCount - 1) % barSize > 0) { // 글이 조금 남으면 다음 페이지에 넘어가도록
			endPage++;
		}

		
		Map<String, Object> result = new HashMap();
		result.put("boards", boards);
		result.put("startPage", startPage);
		result.put("lastPage", lastPage);
		result.put("endPage", endPage);
		
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
		boardDao.insertBoardFile(board.getBoardFile());
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
