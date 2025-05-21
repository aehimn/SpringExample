package com.haemin.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.haemin.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// new_review 테이블에서 전달 받은 id와 일치하는 행 조회
	public Review selectReview(@Param("id") int id);

}
