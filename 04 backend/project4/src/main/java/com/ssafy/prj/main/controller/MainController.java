package com.ssafy.prj.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.prj.user.model.dao.UserDAO;
import com.ssafy.prj.user.model.dao.UserDAOImpl;
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

@WebServlet("/main")
public class MainController extends HttpServlet {
	
	private VideoDAO videoDao;
	private UserDAO userDao;
	public MainController() {
		videoDao = VideoDAOImpl.getInstance(); // 데이터 처리를 위한 클래스를 불러온다
		userDao = UserDAOImpl.getInstance();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("메인 컨트롤러 서비스 메서드 실행");
		// the upper body
		// Lower body
		// the abdomen
		// Whole body
		// cardio
		// Stretching
		List<Video> videos = new ArrayList<>(); // 조회수 
		List<Video> upperVideos = new ArrayList<>();//상체
		List<Video> lowerVideos = new ArrayList<>();//하체
		List<Video> wholeVideos = new ArrayList<>();//전신
		List<Video> abdomanVideos = new ArrayList<>();//복부
		List<Video> cardioVideos = new ArrayList<>();//유산소
		List<Video> stretchVideos = new ArrayList<>();//스트레칭
		String part = null;
		try {
			videos = videoDao.selectVideo();
			upperVideos = videoDao.selectVideosByParts("상체");
			lowerVideos = videoDao.selectVideosByParts("하체");
			wholeVideos = videoDao.selectVideosByParts("전신");
			abdomanVideos = videoDao.selectVideosByParts("복부");
			cardioVideos = videoDao.selectVideosByParts("유산소");
			stretchVideos = videoDao.selectVideosByParts("스트레칭");
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("userInfo");
			if(user != null) {
				part = userDao.selectMinExercise(user.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		req.setAttribute("videos", videos);
		req.setAttribute("upperVideos", upperVideos);
		req.setAttribute("lowerVideos", lowerVideos);
		req.setAttribute("wholeVideos", wholeVideos);
		req.setAttribute("abdomanVideos", abdomanVideos);
		req.setAttribute("cardioVideos", cardioVideos);
		req.setAttribute("stretchVideos", stretchVideos);
		req.setAttribute("part", part);
		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
		rd.forward(req, resp);
		System.out.println("--------------포워딩 완료 ----------------------");
	}
}








