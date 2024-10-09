package com.ssafy.prj.video.service;

import java.util.List;

import com.ssafy.prj.video.model.dto.Video;


public interface VideoService {

//	void update(Board board) throws Exception;

//	void delete(int no) throws Exception;

	Video detail(String id) throws Exception;

	List<Video> list() throws Exception;

//	void write(Board board) throws Exception;
}
