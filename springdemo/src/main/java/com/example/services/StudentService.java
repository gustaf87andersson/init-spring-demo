package com.example.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entities.Student;
import com.example.repositories.StudentInMemoryRepo;

@Service
public class StudentService {

	@Autowired
	private StudentInMemoryRepo studentRepo;
	
	public Collection<Student> getAll() {		
		return studentRepo.getAll();		
	}
	
	public Student getById(int id) {
		return studentRepo.getById(id);
	}
	
	public Student addNewStudent(Student student) {		
		return studentRepo.addNewStudent(student);
	}
	
	public Student updateStudent(int id, Student updatedStudent) {		
		return studentRepo.updateStudent(id, updatedStudent);
	}
	
	public void deleteStudent(int id) {
		studentRepo.deleteStudent(id);
	}
	
}
