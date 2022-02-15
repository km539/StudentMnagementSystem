package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.StudentEntity.Student;
import com.example.demo.StudentRepository.StudentRepository;

@SpringBootApplication
public class SpringDataJpaCourceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCourceApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Kyoji","Matsushima","Kyoji@gmail.com");
		studentRepository.save(student1);
		
		Student student2 = new Student("Hiroki","Suzuki","Hiroki@gmail.com");
		studentRepository.save(student2);
		
		Student student3 = new Student("Takeru","Kawashima","Takeru@gmail.com");
		studentRepository.save(student3);
	}

}
