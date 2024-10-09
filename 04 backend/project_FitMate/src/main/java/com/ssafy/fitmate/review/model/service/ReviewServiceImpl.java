package com.ssafy.fitmate.review.model.service;

import java.util.List;

import com.ssafy.fitmate.review.model.Review;
import com.ssafy.fitmate.review.model.dao.ReviewDAO;
import com.ssafy.fitmate.review.model.dao.ReviewDAOImpl;

public class ReviewServiceImpl implements ReviewService {

	private ReviewDAO reviewDao;
	private static ReviewService instance = new ReviewServiceImpl();
	private ReviewServiceImpl() {
		reviewDao = ReviewDAOImpl.getInstance();
	}
	public static ReviewService getInstance() {
		return instance;
	}
	
	@Override
	public List<Review> listReview() throws Exception {
		return reviewDao.selectReview();
	}
	@Override
	public Review detailReview(int reviewId) throws Exception {
		return reviewDao.selectReviewByPK(reviewId);
	}

}

//C            -> S             -> D
//List<Review> <- List<Review>  <- List<Review>
//공유