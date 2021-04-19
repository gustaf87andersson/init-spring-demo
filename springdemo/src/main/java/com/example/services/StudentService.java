package com.example.services;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Student;
import com.example.repositories.StudentInMemoryRepository;
import com.example.requests.AddStudentRequest;
import com.example.requests.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	private StudentInMemoryRepository studentRepo;
	
	
	public Collection<Student> getAll() {
		return studentRepo.getAll();
	}
	
	public Student getById(UUID id) {
		return studentRepo.getById(id);
	}
	
	public Student addStudent(AddStudentRequest request) {		
		var student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setCreatedAt(new Date());
		
		return studentRepo.addStudent(student);		
	}
	
	public Student updateStudent(UUID id, UpdateStudentRequest request) {		
		var student = studentRepo.getById(id);		
		student.setLastName(request.getLastName());
		student.setUpdatedAt(new Date());
		return studentRepo.updateStudent(id, student);
	}
	
	public void deleteStudent(UUID id) {
		studentRepo.deleteStudent(id);		
	}	
	
}
