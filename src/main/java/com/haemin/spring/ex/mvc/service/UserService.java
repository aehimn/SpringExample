package com.haemin.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haemin.spring.ex.mvc.domain.User;
import com.haemin.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// 가장 최근에 등록한 사용자 정보 얻어오기
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	public int addUser(User user) {
		
		int count = userRepository.insertUser(user);
		return count;
		
	}
	
	// 전달 받은 email이 중복된 것인지 판별
	public boolean isDuplicateEmail(String email) {
		int count = userRepository.selectCountByEmail(email);
		if(count == 0) {
			// 중복 안됨
			return false;
		} else {
			// 중복됨
			return true;
		}
	}

}
