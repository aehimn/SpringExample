package com.haemin.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haemin.spring.ex.jpa.domain.Student;
import com.haemin.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		Student result = studentRepository.save(student);
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		
		// 수정대상 행 조회
		// 조회 결과 객체 얻어 오기
		// 객체에 수정사항 적용
		// 수정된 객체를 저장
		
		// Optional
		// null일 수도 있는 객체를 감싸 놓은 클래스
		// null 처리에 필요한 기능을 포함
		// null을 통해서 발생될 수 있는 NullPointerException 위험을 줄이기 위한 용도
		// null일 수도 있는 객체를 return 하는 메소드에서 return type 으로 활용
		// (내가 리턴할 객첵 널일 수도 있으니 좀 신경써서 처리해라)
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		if(optionalStudent.isPresent()) {
			// null이 아니다
			Student student = optionalStudent.get();
			
			student = student.toBuilder().dreamJob(dreamJob).build();
			
			Student result = studentRepository.save(student);
			
			return result;
		} else {
			// null이다
			return null;
		}
		
	}
	
	public void deleteStudent(int id) {
		// 삭제 대상 행을 조회 한다.
		// 조회된 행을 삭제 한다.
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			studentRepository.delete(student);
		}
	}

}
