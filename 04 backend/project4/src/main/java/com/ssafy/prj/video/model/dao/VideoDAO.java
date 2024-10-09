package com.ssafy.prj.video.model.dao;

import java.util.List;

import com.ssafy.prj.video.model.dto.Video;


public interface VideoDAO {
	
	void insertVideo(Video video) throws Exception;

	List<Video> selectVideo() throws Exception;

	Video selectVideoById(String id) throws Exception;
	
	List<Video> selectVideosByParts(String part) throws Exception;

	void deleteVideo(String id) throws Exception;

	void updateViewCnt(String id) throws Exception;

	void updateVideo(Video board) throws Exception;

	boolean isLiked(String id, String videoId) throws Exception;

	boolean isSubscribed(String id, String channel) throws Exception;

}
