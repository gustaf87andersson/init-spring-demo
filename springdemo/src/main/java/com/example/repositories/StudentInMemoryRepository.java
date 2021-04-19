package com.example.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.entities.Student;

@Service
public class StudentInMemoryRepository {
	
	Map<UUID, Student> students = new HashMap<UUID, Student>();	
	
	public Collection<Student> getAll() {		
		return students.values();
	}
	
	public Student getById(UUID id) {
		return students.get(id);
	}
	
	public Student addStudent(Student student) {
		students.put(student.getId(), student);
		return students.get(student.getId());
	}
	
	public Student updateStudent(UUID id, Student student) {
		students.put(id, student);
		return students.get(id);
	}
	
	public void deleteStudent(UUID id) {
		students.remove(id);
	}
	
}
