package com.ssafy.mvc.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	private final ResourceLoader resourceLoader;
	
	public BoardServiceImpl(BoardDao boardDao, ResourceLoader resourceLoader) {
		this.boardDao = boardDao;
		this.resourceLoader = resourceLoader;
	}
	
	
	@Override
	public List<Board> getBoardList() {
		System.out.println("모든 게시글 가지고 왔습니다.");
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id+"번 글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성했습니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public boolean removeBoard(int id) {
		System.out.println("게시글 삭제합니다.");
		int result = boardDao.deleteBoard(id);
		System.out.println(result);
//		if(result == 1)return true;
//		return false;
		return result == 1; //위 두 코드 간략화
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글을 수정합니다.");
		boardDao.updateBoard(board);
	}


	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

	@Override
	public void fileUpload(MultipartFile file, Board board) {
		if(file != null && file.getSize() > 0) {
			try {
				String fileName = file.getOriginalFilename(); //실제 파일 이름
				// 사실... 확장자를 따로 저장하는 처리가 필요하긴 한데.. 스킵!
				String fileId =UUID.randomUUID().toString(); // 고유한 이름(확장자 날아감)
				// 게시글 바구니를 확장 시켜서 파일 정보도 저장해보기~!
				board.setFileId(fileId);
				board.setFileName(fileName);
				
				//어디에 저장할지 정하기
				Resource resource = resourceLoader.getResource("classpath:/static/img");
				//실제로 저장하기
				file.transferTo(new File(resource.getFile(), fileId));
			//////////// 위 코드까지 정상 수행되면..
				boardDao.insertBoard(board);
				boardDao.insertFile(board); // 이 두줄 순서 바꾸면 오류남. 외래키 받아서 생성해야 해서. 
				// keyProperty="id" useGeneratedKeys="true" 이게 있어서 번호키 받아옴. 
				
			
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
