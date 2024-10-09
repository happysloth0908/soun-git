package com.ssafy.prj.user.model.service;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.prj.user.model.dao.UserDAO;
import com.ssafy.prj.user.model.dao.UserDAOImpl;
import com.ssafy.prj.user.model.dto.ExRecord;
import com.ssafy.prj.user.model.dto.User;
import com.ssafy.prj.video.model.dao.VideoDAO;
import com.ssafy.prj.video.model.dao.VideoDAOImpl;
import com.ssafy.prj.video.model.dto.Video;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;
	private VideoDAO videoDao;
	
	private UserServiceImpl() {
		userDao = UserDAOImpl.getInstance();
		videoDao = VideoDAOImpl.getInstance();
	}
	
	private static UserService instance = new UserServiceImpl();
	
	public static UserService getInstance() {
		return instance;
	}
	
	@Override
	public void signup(User user) throws Exception {
		userDao.insertUser(user);
	}
	
	@Override
	public User login(User user) throws Exception {
		return userDao.selectUser(user);
	}
	
	@Override
	public List<String> subscribeList(String id) throws Exception {
		return userDao.selectSubscribe(id);
	}
	
	@Override
	public void subscribe(String id, String channel) throws Exception {
		userDao.insertSubscribe(id, channel);
		
	}
	
	@Override
	public void unSubscribe(String id, String channel) throws Exception {
		userDao.deleteSubscribe(id, channel);
	}
	

	@Override
	public void like(String id, String video_id) throws Exception {
		userDao.insertLike(id, video_id);
		
	}
	
	@Override
	public void unLike(String id, String video_id) throws Exception {
		userDao.deleteLike(id, video_id);
	}
	
	@Override
	public List<Video> likeList(String id) throws Exception {
		List<Video> list = new ArrayList<>();
		for(String videoId : userDao.selectLike(id)) {
			list.add(videoDao.selectVideoById(videoId));
		}
		return list;
	}

	@Override
	public void recording(ExRecord exRecord) throws Exception {
		userDao.InsertExercise(exRecord);
	}

	@Override
	public List<ExRecord> exList(String id) throws Exception {
		return userDao.selectExercise(id);
	}
	

}
