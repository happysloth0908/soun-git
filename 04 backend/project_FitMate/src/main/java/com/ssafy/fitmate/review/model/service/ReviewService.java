package com.ssafy.fitmate.review.model.service;

import java.util.List;

import com.ssafy.fitmate.review.model.Review;

public interface ReviewService {

	List<Review> listReview() throws Exception;

	Review detailReview(int reviewId) throws Exception;

}
