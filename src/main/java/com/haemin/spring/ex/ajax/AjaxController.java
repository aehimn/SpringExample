package com.haemin.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@GetMapping("/ajax/ex01")
	public String ex01() {
		return "ajax/ex01";
	}
	
	// response에 데이터가 담기는 페이지
	// API <-> View (html)
	// 이름과 생년월일을 전달 받고 이름과 나이를 응답으로 전달한다.
	// 응답에 데이터(json)만 포함
	@ResponseBody
	@GetMapping("/ajax/person")
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday) {
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2025 - year + 1;
		
		// {"name":"김인규:, "age":32}
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		return personMap;
	}

}
