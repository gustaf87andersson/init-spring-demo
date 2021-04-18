package com.example.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entities.Student;

@Service
public class StudentInMemoryRepo {
	
	Map<UUID, Student> students = new HashMap<UUID, Student>();
	
	public Collection<Student> getAll() {		
		return students.values();		
	}
	
	public Student getById(UUID id) {
		return students.get(id);
	}
	
	public Student addNewStudent(Student student) {		
		students.put(student.getId(), student);
		return student;
	}
	
	public Student updateStudent(UUID id, Student updatedStudent) {		
		Student student = students.get(id);
		student.setFirstName(updatedStudent.getFirstName());
		student.setLastName(updatedStudent.getLastName());		
		return student;
	}
	
	public void deleteStudent(UUID id) {
		students.remove(id);
	}	

}
