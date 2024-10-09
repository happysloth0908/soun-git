package com.ssafy.fitmate.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.util.DBUtil;
import com.ssafy.fitmate.review.model.Review;

public class ReviewDAOImpl implements ReviewDAO {
	private DBUtil dbUtil;
	private static ReviewDAO instance = new ReviewDAOImpl();
	private ReviewDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static ReviewDAO getInstance() {
		return instance;
	}
	@Override
	public List<Review> selectReview() throws SQLException {
		// DB에 있는 review 테이블에 있는 데이터를 모두 조회해서
		// List<Review>으로 담아서 반환한다.
		// 1. DB에 연결
		// 2. 쿼리를 만들고
		// 3. 쿼리를 실행하기 위해서 Statement 객체를 얻고
		// 4. 쿼리를 실행하고
		// 5. 결과를 가져와서 List<Review> 담아서 반환
		// 6. 연결 객체들을 닫아주자... 
		
		try (
			Connection con = dbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"select review_id, title, user_id, view_cnt, reg_time from review order by review_id desc"
			);
		) {
			List<Review> reviews = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setTitle(rs.getString("title"));
				review.setUserId(rs.getString("user_id"));
				review.setViewCnt(rs.getInt("view_cnt"));
				review.setRegTime(rs.getString("reg_time"));
				reviews.add(review);
			}
			return reviews;
		}
	}
	@Override
	public Review selectReviewByPK(int reviewId) throws SQLException {
		try (
			Connection con = dbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"select review_id, title, user_id, view_cnt, reg_time, content from review where review_id = ?"
			);
		) {
			pstmt.setInt(1, reviewId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setTitle(rs.getString("title"));
				review.setUserId(rs.getString("user_id"));
				review.setViewCnt(rs.getInt("view_cnt"));
				review.setRegTime(rs.getString("reg_time"));
				review.setContent(rs.getString("content"));
				return review;
			}
		}
		return null;
	}

}
