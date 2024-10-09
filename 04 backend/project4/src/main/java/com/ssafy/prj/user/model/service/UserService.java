package com.ssafy.prj.user.model.service;

import java.util.List;

import com.ssafy.prj.user.model.dto.ExRecord;
import com.ssafy.prj.user.model.dto.User;
import com.ssafy.prj.video.model.dto.Video;

public interface UserService {

	void signup(User user) throws Exception;

	User login(User user) throws Exception;

	List<String> subscribeList(String id) throws Exception;

	void unSubscribe(String id, String channel) throws Exception;

	void like(String id, String video_id) throws Exception;

	List<Video> likeList(String id) throws Exception;

	void unLike(String id, String video_id) throws Exception;

	void subscribe(String id, String channel) throws Exception;

	void recording(ExRecord exRecord) throws Exception;

	List<ExRecord> exList(String id) throws Exception;

}