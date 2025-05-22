package com.haemin.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.haemin.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// new_review 테이블에서 전달 받은 id와 일치하는 행 조회
	public Review selectReview(@Param("id") int id);

	// storeId, menu, userName, point, review 를 한행 저장하는 기능
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	// Review 객체를 통해 한행 저장하는 기능
	public int insertReviewByObject(Review review);
	
}
