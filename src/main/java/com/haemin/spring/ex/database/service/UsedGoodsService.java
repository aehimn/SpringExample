package com.haemin.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haemin.spring.ex.database.domain.UsedGoods;
import com.haemin.spring.ex.database.repository.UsedGoodsRepository;

@Service
public class UsedGoodsService {
	
	// 의존성 주입 - DI
	// 객체 생성을 Spring Framework 에서 직접 관리
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	//  중고 게시글 모두 얻어오기
	public List<UsedGoods> getUsedGoodsList() {
		// used_goods 테이블 모든 행 조회
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
		
	}
}