package com.haemin.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haemin.spring.ex.mybatis.domain.Review;
import com.haemin.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달 받은 id와 일치하는 리뷰 정보 얻어오기
	public Review getReview(int id) {
		
		// new_review 테이블에서 전달 받은 id와 일치하는 행 조회
		Review review =  reviewRepository.selectReview(id);
		
		return review;
		
	}
	
	// storeId, menu, userName, point, review 저장 기능
	public int addReview(
			int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	// Review 객체를 통해 리뷰 정보를 저장하는 기능
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		return count;
	}

}
