package com.example.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	@ApiOperation(value = "Get all Students", notes = "Fetches all students in Students API", response = Student.class, responseContainer = "List")
	public Collection<Student> getAll() {
		return studentService.getAll();
	}

	@GetMapping("/{id}")
	public Student getById(@ApiParam(value = "Id of the Student", required = true) @PathVariable Long id) {
		var response = studentService.getById(id);

		if (response == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldnt find any student with provided ID");
		}

		return response;
	}

	@GetMapping("/name/{firstName}")
	public Collection<Student> getByFirstName(@PathVariable String firstName) {
		return studentService.getByFirstName(firstName);
	}

	@PostMapping("/")
	public Student addNewStudent(@Valid @RequestBody AddStudentRequest request) {
		return studentService.addStudent(request);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequest request) {
		return studentService.updateStudent(id, request);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

}
