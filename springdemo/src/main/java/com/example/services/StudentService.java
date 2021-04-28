package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Address;
import com.example.entities.Course;
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

		var courses = new ArrayList<Course>();

		if (request.getCourses().size() > 0) {
			for (Course course : request.getCourses()) {
				var newCourse = new Course();
				newCourse.setId(UUID.randomUUID());
				newCourse.setName(course.getName() != null ? course.getName() : "NoName!");
				courses.add(newCourse);
			}
		}

		var address = new Address();
		address.setId(UUID.randomUUID());
		address.setCity(request.getCity());
		address.setStreet(request.getStreet());

		var student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setCreatedAt(new Date());

		student.setAddress(address);

		student.setCourses(courses);

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
