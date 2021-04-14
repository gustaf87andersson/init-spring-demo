package com.example.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.*;

@RestController
@RequestMapping("/api/students/")
public class StudentsController {

	Map<Integer, Student> students = new HashMap<Integer, Student>();	
	
	@GetMapping("/")
	public Collection<Student> getAll() {		
		return students.values();		
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable int id) {
		return students.get(id);
	}
	
	@PostMapping("/")
	public Student addNewStudent(@RequestBody Student student) {		
		students.put(student.getId(), student);
		return student;
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {		
		Student student = students.get(id);
		student.setFirstName(updatedStudent.getFirstName());
		student.setLastName(updatedStudent.getLastName());		
		return student;
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id) {
		students.remove(id);
	}
	
}
