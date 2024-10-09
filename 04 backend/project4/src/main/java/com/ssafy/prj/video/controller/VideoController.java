package com.ssafy.prj.video.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.prj.user.model.dto.User;
import com.ssafy.prj.video.model.dao.VideoDAO;
import com.ssafy.prj.video.model.dao.VideoDAOImpl;
import com.ssafy.prj.video.model.dto.Video;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/video")
public class VideoController extends HttpServlet{
	
	private VideoDAO videoDao;
	public VideoController() {
		videoDao = VideoDAOImpl.getInstance(); // 데이터 처리를 위한 클래스를 불러온다
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		try {
			switch(action){
			case "videoDetail" :
				videoDetail(req,resp);
				break;
			case "" :
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// 톰켓한테 예외를 만들어서 던진다.
			throw new ServletException(e);
		}
		
		
	
	}

	private void videoDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String videoId = req.getParameter("video_id");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userInfo");
		String id = "";
		if(user != null) {
			id = user.getId();
		}
		boolean isLiked = videoDao.isLiked(id, videoId);
		try {
			videoDao.updateViewCnt(videoId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("video");
		Video video = new Video();
		try {
			video = videoDao.selectVideoById(videoId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isSubscribed = videoDao.isSubscribed(id, video.getChannel());
		
		req.setAttribute("video", video);
		req.setAttribute("isLiked", isLiked);
		req.setAttribute("isSubscribed", isSubscribed);
		RequestDispatcher rd = req.getRequestDispatcher("/board?action=list");
		rd.forward(req, resp);
	}
	
	
	
	
	
}
