package com.haemin.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")
	public String thymeleafResponse() {
		
		// html 파일 경로 리턴
		// src/main/resources/templates
		// .html 생략
		return "lifecycle/ex02";
		
	}
	
}
