package com.example.services;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Student;
import com.example.repositories.StudentInMemoryRepo;
import com.example.requests.AddStudentRequest;

@Service
public class StudentService {

	@Autowired
	private StudentInMemoryRepo studentRepo;
	
	public Collection<Student> getAll() {		
		return studentRepo.getAll();		
	}
	
	public Student getById(UUID id) {
		return studentRepo.getById(id);
	}
	
	public Student addNewStudent(AddStudentRequest request) {
		var student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setCreatedAt(new Date());
		
		return studentRepo.addNewStudent(student);
	}
	
	public Student updateStudent(UUID id, Student student) {
		student.setUpdatedAt(new Date());
		return studentRepo.updateStudent(id, student);
	}
	
	public void deleteStudent(UUID id) {
		studentRepo.deleteStudent(id);
	}
	
}
