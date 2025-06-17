package com.haemin.spring.ex.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haemin.spring.ex.jpa.domain.Student;
import com.haemin.spring.ex.jpa.repository.StudentRepository;
import com.haemin.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// 경고!!!!!
	// 절대 컨트롤러에서 레파지토리 객체 사용 불가
	// 예제 진행 편의를 위해서 추가
	@Autowired
	private StudentRepository studentRepository;
	
	// 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		return student;
	}
	
	// 수정 기능
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 학생 장래 희망을 강사로 변경
		Student student = studentService.updateStudent(4, "강사");
		return student;
	}
	
	// 삭제 기능
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 3인 학생 정보 삭제
		studentService.deleteStudent(4);
		return "삭제 성공";
	}
	
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		List<Student> studentList = null;
		// 모든 학생 정보 조회
//		studentList = studentRepository.findAll();
		
//		studentList = studentRepository.findAllByOrderByIdDesc();
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
		studentList = studentRepository.findByName("김인규");
		
		studentList = studentRepository.selectByQuery("개발자");
		return studentList;
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
