package com.haemin.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haemin.spring.ex.database.domain.UsedGoods;
import com.haemin.spring.ex.database.service.UsedGoodsService;

//  request response 관련 처리
@Controller
public class UsedGoodsController {

@Autowired
private UsedGoodsService usedGoodsService;

//  중고 게시글 모든 정보를 response 담는 페이지
@RequestMapping("/db/usedgoods/list")
@ResponseBody
public List<UsedGoods> usedGoodsList() {
// 중고 게시글의 모든 정보 얻어오기
List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();

return usedGoodsList;
}
}