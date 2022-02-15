package com.example.demo.StudentService;

import java.util.List;

import com.example.demo.StudentEntity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student studentGetById(long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(long id);
}
