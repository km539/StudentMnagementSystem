package com.example.demo.StudentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.StudentEntity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
