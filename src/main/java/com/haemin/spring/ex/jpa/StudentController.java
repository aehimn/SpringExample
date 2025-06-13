package com.haemin.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haemin.spring.ex.jpa.domain.Student;
import com.haemin.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addService("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		return student;
	}
	
	// 수정 기능
	@GetMapping("/update")
	public  updateStudent() {
		// id가 3인 학생 장래 희마ㅏㅇ을 강사로 변경
		
	}
	
	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
//		Student student = new Student(4, "김인규", "010-1234-5678", "lecture@hagulu.com", "프로그래머", LocalDateTime.now(), LocalDateTime.now());
//		student.setDreamJob("강사");
		// builder 패턴
		Student student = Student.builder()
				.name("유재석")
				.dreamJob("개그맨")
				.phoneNumber("010-1111-2222")
				.build();
		return student;
	}
	
}
