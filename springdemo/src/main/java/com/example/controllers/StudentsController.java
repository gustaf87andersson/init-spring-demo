package com.example.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.*;
import com.example.services.StudentService;

@RestController
@RequestMapping("/api/students/")
public class StudentsController {

	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public Collection<Student> getAll() {		
		return studentService.getAll();		
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable int id) {
		return studentService.getById(id);
	}
	
	@PostMapping("/")
	public Student addNewStudent(@RequestBody Student student) {		
		return studentService.addNewStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {		
		return studentService.updateStudent(id, updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
	
}
