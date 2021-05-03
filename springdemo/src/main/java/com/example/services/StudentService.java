package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.entities.Address;
import com.example.entities.Course;
import com.example.entities.Student;
import com.example.repositories.StudentRepository;
import com.example.requests.AddStudentRequest;
import com.example.requests.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Collection<Student> getAll() {
		Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
		return studentRepo.findAll(sort);
	}

	public Student getById(Long id) {
		return studentRepo.findById(id).get();
	}

	public Collection<Student> getByFirstName(String firstName) {
		return studentRepo.findByFirstName(firstName);
	}

	public Student addStudent(AddStudentRequest request) {

		var courses = new ArrayList<Course>();

		if (request.getCourses().size() > 0) {
			for (Course course : request.getCourses()) {
				var newCourse = new Course();
				newCourse.setName(course.getName() != null ? course.getName() : "NoName!");
				courses.add(newCourse);
			}
		}

		var address = new Address();
		address.setCity(request.getCity());
		address.setStreet(request.getStreet());

		var student = new Student();
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setCreatedAt(new Date());

		// student.setAddress(address);

		// student.setCourses(courses);

		return studentRepo.save(student);
	}

	public Student updateStudent(Long id, UpdateStudentRequest request) {
		var student = studentRepo.findById(id).get();
		student.setLastName(request.getLastName());
		student.setUpdatedAt(new Date());
		return studentRepo.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}

}
