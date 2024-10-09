package com.ssafy.prj.video.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.prj.video.model.dto.Video;
import com.ssafy.prj.util.DBUtil;

public class VideoDAOImpl implements VideoDAO {

	
	private VideoDAOImpl() {}
	
	private static VideoDAO instance = new VideoDAOImpl();
	
	public static VideoDAO getInstance() {
		return instance;
	}
	
	DBUtil dbUtil = DBUtil.getInstance();
	
	@Override
	public void insertVideo(Video video) throws Exception {
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		String sql = "INSERT INTO video(video_id, title, src, part, view_cnt, channel) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, video.getVideo_id());
		pstmt.setString(2, video.getTitle());
		pstmt.setString(3, video.getSrc());
		pstmt.setString(4, video.getPart());
		pstmt.setInt(5, video.getView_cnt());
		pstmt.setString(6, video.getChannel());
		pstmt.executeUpdate();
	}

	@Override
	public List<Video> selectVideo() throws Exception {
		System.out.println("VideoDAOImpl selectVideo 메서드 실행");
		
		List<Video> list = new ArrayList<>();
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		// SQL문 작성
		String sql = "SELECT video_id, title, src, part, view_cnt, channel FROM video ORDER BY view_cnt DESC";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		// SQL문 실행하기 : SELECT문(executeQuery), 그 외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String video_id = rs.getString("video_id");
			String title = rs.getString("title");
			String src = rs.getString("src"); 
			String part = rs.getString("part");
			int view_cnt = rs.getInt("view_cnt");
			String channel = rs.getString("channel");
			
			Video video = new Video();
			
			video.setVideo_id(video_id);
			video.setTitle(title);
			video.setSrc(src);
			video.setPart(part);
			video.setView_cnt(view_cnt);
			video.setChannel(channel);
			
			list.add(video);
		}
		System.out.println(list);
		return list;
		
	}
	
	@Override
	public List<Video> selectVideosByParts(String PART) throws Exception {
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		// SQL문 작성
		String sql = "SELECT video_id, title, src, part, view_cnt, channel FROM video WHERE part = ?";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, PART);
		
		ResultSet rs = pstmt.executeQuery();
		
		Video partvideo = null;
		List<Video> list = new ArrayList<>();
		
		while(rs.next()) {
			String video_id = rs.getString("video_id");
			String title = rs.getString("title");
			String src = rs.getString("src");
			String part = rs.getString("part");
			int view_cnt = rs.getInt("view_cnt");
			String channel = rs.getString("channel");
			
			partvideo = new Video();
			
			partvideo.setVideo_id(video_id);
			partvideo.setTitle(title);
			partvideo.setSrc(src);
			partvideo.setPart(part);
			partvideo.setView_cnt(view_cnt);
			partvideo.setChannel(channel);
			
			list.add(partvideo);
		}
		
		return list;
	}
	
	@Override
	public Video selectVideoById(String id) throws Exception {
		
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		// SQL문 작성
		String sql = "SELECT video_id, title, src, part, view_cnt, channel FROM video WHERE video_id = ?";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		// SQL문 실행하기 : SELECT문(executeQuery), 그 외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		
		Video video = null;
		while(rs.next()) {
			String video_id = rs.getString("video_id");
			String title = rs.getString("title");
			String src = rs.getString("src");
			String part = rs.getString("part");
			int view_cnt = rs.getInt("view_cnt");
			String channel = rs.getString("channel");
			
			video = new Video();
			
			video.setVideo_id(video_id);
			video.setTitle(title);
			video.setSrc(src);
			video.setPart(part);
			video.setView_cnt(view_cnt);
			video.setChannel(channel);
		}
		
		return video;
	}

	@Override
	public void deleteVideo(String id) throws Exception {
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		String sql = "DELETE FROM video WHERE video_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
	}

	@Override
	public void updateViewCnt(String id) throws Exception {
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		String sql = "UPDATE video SET view_cnt = view_cnt + 1 WHERE video_id =?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
	}

	@Override
	public void updateVideo(Video video) throws Exception {
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		String sql = "UPDATE video SET video_id=?, title=?, src=?, part=?, view_cnt=?, channel=? WHERE video_id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, video.getVideo_id());
		pstmt.setString(2, video.getTitle());
		pstmt.setString(3, video.getSrc());
		pstmt.setString(4, video.getPart());
		pstmt.setInt(5, video.getView_cnt());
		pstmt.setString(6, video.getChannel());
		
		pstmt.executeUpdate();
		
	}

	@Override
	public boolean isLiked(String id, String videoId) throws Exception {
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		String sql = "SELECT video_id from liked WHERE user_id = ? AND video_id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, videoId);
		
		ResultSet rs = pstmt.executeQuery();
		
		String video_id = "";
		while(rs.next()) {
			video_id = rs.getString("video_id");
		} if(video_id.equals("")) {
			return false;
		}
		
		return true;
	}

	
	@Override
	public boolean isSubscribed(String id, String channel) throws Exception {
		
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		
		String sql = "SELECT channel from subscribe WHERE user_id = ? AND channel = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, channel);
		
		ResultSet rs = pstmt.executeQuery();
		
		String channelName = "";
		while(rs.next()) {
			channelName = rs.getString("channel");
		} if(channelName.equals("")) {
			return false;
		}
		
		return true;
	}

	
}
