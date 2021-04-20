package com.example.controllers;

import java.util.Collection;
import java.util.UUID;

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
import com.example.requests.AddStudentRequest;
import com.example.requests.UpdateStudentRequest;
import com.example.services.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/students/")
public class StudentsController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/")
	@ApiOperation(
			value = "Get all Students",
			notes = "Fetches all students in Students API",
			response = Student.class,
			responseContainer = "List")
	public Collection<Student> getAll() {		
		return studentService.getAll();		
	}
	
	@GetMapping("/{id}")
	public Student getById(@ApiParam(value = "Id of the Student", required = true) @PathVariable UUID id) {
		return studentService.getById(id);
	}
	
	@PostMapping("/")
	public Student addNewStudent(@RequestBody AddStudentRequest request) {		
		return studentService.addStudent(request);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable UUID id, @RequestBody UpdateStudentRequest request) {		
		return studentService.updateStudent(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable UUID id) {
		studentService.deleteStudent(id);
	}
	
}
