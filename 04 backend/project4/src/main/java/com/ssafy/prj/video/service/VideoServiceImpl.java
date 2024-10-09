package com.ssafy.prj.video.service;

import java.util.List;

import com.ssafy.prj.video.model.dao.VideoDAO;
import com.ssafy.prj.video.model.dao.VideoDAOImpl;
import com.ssafy.prj.video.model.dto.Video;

import jakarta.servlet.annotation.WebServlet;

//@WebServlet("/video")
public class VideoServiceImpl implements VideoService{

	
	private VideoDAO videoDao;

	private VideoServiceImpl() {
		videoDao = VideoDAOImpl.getInstance(); // 데이터 처리를 위한 클래스를 불러온다
	}
	
	private static VideoService instance = new VideoServiceImpl();
	
	public static VideoService getInstance() {
		return instance;
	}
	
//	@Override
//	public void update(Board board) throws Exception {
//		boardDao.updateBoard(board);
//	}


//	@Override
//	public void delete(int no) throws Exception {
//		boardDao.deleteBoard(no);
//	}

	@Override
	public Video detail(String id) throws Exception {
		videoDao.updateViewCnt(id);
		return videoDao.selectVideoById(id);
	}

	@Override
	public List<Video> list() throws Exception {
		return videoDao.selectVideo();
	}

//	@Override
//	public void write(Video video) throws Exception {
//		videoDao.insertVideo(video);
//	}
	
}
