package com.ssafy.mvc.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.util.DBUtil;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private DBUtil db;
	
	public UserDAOImpl() {
		db = DBUtil.getInstance();
	}
	
	@Override
	public String checkIdPass(String id, String pw) throws Exception {
		String name;
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"""
					SELECT id, password, name FROM user WHERE id = ? AND password = ?
					"""
					
					);
				
				){
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}else {
				return null;
			}
		}
		return name;
		
		
		
		
	}

}
