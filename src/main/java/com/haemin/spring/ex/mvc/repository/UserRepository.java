package com.haemin.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.haemin.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	
	public User selectLastUser();
	
	public int insertUser(User user);
	
	// 전달받은 email이 포함된 행의 개수 조회
	public int selectCountByEmail(@Param("email") String email);

}
