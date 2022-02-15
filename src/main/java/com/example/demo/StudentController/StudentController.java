package com.example.demo.StudentController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.StudentEntity.Student;
import com.example.demo.StudentService.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	
	
	 public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


	  @GetMapping("/students")
	  public String listStudents(Model model) {
	    //Iterable<Student> students = studentService.getAllStudents();
	    model.addAttribute("students", studentService.getAllStudents());
	    return "students";
	  }
	  
	  @GetMapping("/students/new")
	  public String createStudentForm(Model model) {
	    Student student = new Student();
	    model.addAttribute("student", student);
	    return "create_student";
	  }
	  
	  @PostMapping("/students")
	  public String saveStudent(@ModelAttribute("student") Student student) {
		  studentService.saveStudent(student);
		  return "redirect:/students";
	  }
	  
	  @GetMapping("/students/eidt/{id}")
	  public String editStudentForm(@PathVariable long id, Model model) {
		  model.addAttribute("student", studentService.studentGetById(id));
		  return "edit_student";
	  }
	  
	  @PostMapping("/students/{id}")
	  public String updateStudent(@PathVariable long id, 
			  @ModelAttribute("student") Student student,
			  Model model) {
		  //get student from database by id
		  Student excistingStudent = studentService.studentGetById(id);
		  excistingStudent.setId(id);
		  excistingStudent.setFirstName(student.getFirstName());
		  excistingStudent.setLastName(student.getLastName());
		  excistingStudent.setEmail(student.getEmail());
		  
		  //update student info
		  studentService.updateStudent(excistingStudent);
		  return "redirect:/students";
	  }
	  
	  //delete excisiting student
	  @GetMapping("/students/{id}")
	  public String deleteStudent(@PathVariable long id) {
		  studentService.deleteStudentById(id);
		  return "redirect:/students";
	  }
}
