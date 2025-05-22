package com.haemin.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haemin.spring.ex.mybatis.domain.Review;
import com.haemin.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 전달 받은 id와 일치하는 리뷰 정보를 response에 json으로 담는다
	@ResponseBody
	@RequestMapping("")
	public Review review(@RequestParam("id") int id) {
		// request parameter 로 id를 전달 받는다
//		String idString = request.getParameter("id");
//		int id = Integer.parseInt(idString);
		
		// 전달 받은 id와 일치하는 리뷰정보 얻어오기
		Review review = reviewService.getReview(id);
		
		return review;
		
	}
	
	// 리뷰를 저장하는 기능
	@ResponseBody
	@RequestMapping("/create")
	public String createReview() {
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
//		int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다.");
		
		int count = reviewService.addReviewByObject(review);
		
		
		// 실행 결과 : 1
		return "실행 결과 : " + count;
	}

}
