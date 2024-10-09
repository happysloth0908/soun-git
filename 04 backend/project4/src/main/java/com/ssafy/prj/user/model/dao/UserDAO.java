package com.ssafy.prj.user.model.dao;

import java.util.List;

import com.ssafy.prj.user.model.dto.ExRecord;
import com.ssafy.prj.user.model.dto.User;
import com.ssafy.prj.video.model.dto.Video;

public interface UserDAO {

	void insertUser(User user) throws Exception;

	User selectUser(User user) throws Exception;

	List<String> selectSubscribe(String id) throws Exception;

	void deleteSubscribe(String id, String channel) throws Exception;
	
	void insertLike(String id, String video_id) throws Exception;

	List<String> selectLike(String id) throws Exception;

	void deleteLike(String id, String video_id) throws Exception;

	void insertSubscribe(String id, String channel) throws Exception;

	void InsertExercise(ExRecord exRecord) throws Exception;

	String selectMinExercise(String id) throws Exception;
	
	List<ExRecord> selectExercise(String id) throws Exception;

}