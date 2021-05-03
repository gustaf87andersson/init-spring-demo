package com.example.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.entities.Student;

@Service
public class StudentInMemoryRepository {

	Map<Long, Student> students = new HashMap<Long, Student>();

	public Collection<Student> getAll() {
		return students.values();
	}

	public Student getById(Long id) {
		return students.get(id);
	}

	public Student addStudent(Student student) {
		students.put(student.getId(), student);
		return students.get(student.getId());
	}

	public Student updateStudent(Long id, Student student) {
		students.put(id, student);
		return students.get(id);
	}

	public void deleteStudent(Long id) {
		students.remove(id);
	}

}
