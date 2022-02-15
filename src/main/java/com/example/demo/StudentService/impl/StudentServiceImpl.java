package com.example.demo.StudentService.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.StudentEntity.Student;
import com.example.demo.StudentRepository.StudentRepository;
import com.example.demo.StudentService.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
	
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public Student studentGetById(long id) {
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
		
	}
	
	

}
