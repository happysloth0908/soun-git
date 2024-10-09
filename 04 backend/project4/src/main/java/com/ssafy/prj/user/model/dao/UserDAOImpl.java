package com.ssafy.prj.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.prj.user.model.dto.ExRecord;
import com.ssafy.prj.user.model.dto.User;
import com.ssafy.prj.util.DBUtil;

public class UserDAOImpl implements UserDAO {
	
	private UserDAOImpl() {}
	
	private static UserDAO instance = new UserDAOImpl();
	
	public static UserDAO getInstance() {
		return instance;
	}
	DBUtil dbUtil = DBUtil.getInstance();
	
	@Override
	public void insertUser(User user) throws Exception {
		
		String sql = "INSERT INTO users(user_id, password, email) VALUES(?, ?, ?)";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		try(con; pstmt) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			
			pstmt.executeUpdate();
		}
		
	}
	
	
	@Override
	public User selectUser(User user) throws Exception {

		String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		try(con; pstmt; rs) {
			User u = null;
			if(rs.next()) {
				String id = rs.getString("user_id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				u = new User();
				u.setId(id);
				u.setPassword(password);
				u.setEmail(email);
			}
			return u;
		}
	}
	
	@Override
	public List<String> selectSubscribe(String id) throws Exception {
		List<String> list = new ArrayList<>();
		String sql = "SELECT channel FROM subscribe WHERE user_id = ?";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		try(con; pstmt; rs) {
			while(rs.next()) {
				String channel = rs.getString("channel");
				list.add(channel);
			}
		}
		
		return list;

		
		
	}

	@Override
	public void insertSubscribe(String id, String channel) throws Exception {
		String sql = "INSERT INTO subscribe(user_id, channel) VALUES(?, ?)";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, channel);
		try(con; pstmt) {
			pstmt.executeUpdate();
		}
		
	}
	
	@Override
	public void deleteSubscribe(String id, String channel) throws Exception {
		
		String sql = "DELETE FROM subscribe WHERE user_id = ? AND channel = ?";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, channel);
		try(con; pstmt) {
			pstmt.executeUpdate();
		}
	}
	
	
	@Override
	public void insertLike(String id, String video_id) throws Exception {
		String sql = "INSERT INTO liked(user_id, video_id) VALUES(?, ?)";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, video_id);
		try(con; pstmt) {
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public List<String> selectLike(String id) throws Exception {
		List<String> list = new ArrayList<>();
		String sql = "SELECT video_id FROM liked WHERE user_id = ?";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		try(con; pstmt; rs) {
			while(rs.next()) {
				list.add(rs.getString("video_id"));
			}
		}
		return list;
	}


	@Override
	public void deleteLike(String id, String video_id) throws Exception {
		String sql = "DELETE FROM liked WHERE user_id = ? AND video_id = ?";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, video_id);
		try(con; pstmt) {
			pstmt.executeUpdate();
		}
		
	}
	
	@Override
	public void InsertExercise(ExRecord exRecord) throws Exception {

		String sql = "INSERT INTO exRecord(part, ex_date, ex_time, user_id) VALUES(?, ?, ?, ?)";
		
		Connection con = dbUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		String[] parts = {"전신", "상체", "하체", "복부", "유산소", "스트레칭"};
		
		try(con; pstmt) {
			for(String p : parts) {
				if(p.equals(exRecord.getPart())) {
					pstmt.setString(1, exRecord.getPart());
					pstmt.setInt(3, exRecord.getExTime());
				}
				else {
					pstmt.setString(1, p);
					pstmt.setInt(3, 0);
				}
				pstmt.setString(2, exRecord.getExDate());
				pstmt.setString(4, exRecord.getUserId());
				pstmt.executeUpdate();
			}
		}
		
	}
	
	@Override
	public String selectMinExercise(String id) throws Exception {
		
		String part = null;
		
		String sql = "SELECT sum(ex_time), part \r\n"
				+ "FROM exRecord \r\n"
				+ "WHERE ex_date BETWEEN date(DATE_ADD(NOW(), INTERVAL-1 WEEK)) AND date(now())\r\n"
				+ "AND user_id = ?\r\n"
				+ "GROUP BY part\r\n"
				+ "ORDER BY sum(ex_time) ASC\r\n"
				+ "LIMIT 1";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		try(con; pstmt; rs) {
			if(rs.next()) {
				part = rs.getString("part");
			}
		}
		return part;
	}


	@Override
	public List<ExRecord> selectExercise(String id) throws Exception {
		List<ExRecord> list = new ArrayList<>();
		String sql = "SELECT ex_date, part, ex_time FROM exRecord WHERE user_id = ? AND ex_time > 0 ORDER BY ex_date ASC";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		try(con; pstmt; rs) {
			while(rs.next()) {
				ExRecord exRecord = new ExRecord();
				exRecord.setExDate(rs.getString("ex_date"));
				exRecord.setPart(rs.getString("part"));
				exRecord.setExTime(rs.getInt("ex_time"));
				list.add(exRecord);
			}
		}
		return list;
	}
	
}
