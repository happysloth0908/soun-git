package com.ssafy.fitmate.review.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.fitmate.review.model.Review;

public interface ReviewDAO {

	List<Review> selectReview() throws SQLException;

	Review selectReviewByPK(int reviewId) throws SQLException;

}
