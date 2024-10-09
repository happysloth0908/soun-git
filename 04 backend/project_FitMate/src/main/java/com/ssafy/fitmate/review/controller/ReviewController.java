package com.ssafy.fitmate.review.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.fitmate.review.model.Review;
import com.ssafy.fitmate.review.model.service.ReviewService;
import com.ssafy.fitmate.review.model.service.ReviewServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private ReviewService reviewService;
	
	public ReviewController() {
		reviewService = ReviewServiceImpl.getInstance();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");
			if ("list".equals(action)) {
				list(req, res);
			} else if ("detail".equals(action)) {
				detail(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	private void detail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		Review review = reviewService.detailReview(reviewId);
		req.setAttribute("review", review);
		RequestDispatcher rd = req.getRequestDispatcher("/review/review_detail.jsp");
		rd.forward(req, res);
	}
	
	private void list(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// review_list.jsp 이동이 목표임... , forward, redirect
		// 화면에서 사용할 데이터를 구해서 공유하는 작업 
		// 컨트롤러는 자신이 직접 화면에 필요한 데이터를 구하지 않는다.
		// 누구한테?? 서비스한테 대신 구해 달라고 한다.
		List<Review> reviews = reviewService.listReview();
		req.setAttribute("reviews", reviews);
		RequestDispatcher rd = req.getRequestDispatcher("/review/review_list.jsp");
		rd.forward(req, res);
//		res.sendRedirect(req.getContextPath() + "/review/review_list.jsp");
	}
	
}
