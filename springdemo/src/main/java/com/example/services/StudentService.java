package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.entities.Address;
import com.example.entities.Course;
import com.example.entities.Student;
import com.example.repositories.AddressSqlRepository;
import com.example.repositories.CourseSqlRepository;
import com.example.repositories.StudentSqlRepository;
import com.example.requests.AddCourseRequest;
import com.example.requests.AddStudentRequest;
import com.example.requests.UpdateStudentRequest;

@Service
@RequiredArgsConstructor
public class StudentService {

	Logger logger = LoggerFactory.getLogger(StudentService.class);
	private final StudentSqlRepository studentRepo;
	private final AddressSqlRepository addressRepo;
	private final CourseSqlRepository courseRepo;

	// public StudentService(StudentSqlRepository studentRepo, AddressSqlRepository addressRepo, CourseSqlRepository courseRepo){
	// 	this.studentRepo = studentRepo;
	// 	this.addressRepo = addressRepo;
	// 	this.courseRepo = courseRepo;
	// }	

	public Collection<Student> getAll() {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		return studentRepo.findAll(sort);
	}

	public Student getById(Long id) {
		return studentRepo.findById(id).get();
	}

	public Collection<Student> getByFirstName(String firstName){
		return studentRepo.findByFirstName(firstName);
	}

	public Collection<Student> getByCity(String city){
		return studentRepo.findByAddressCity(city);
	}

	public Student addStudent(AddStudentRequest request) {	

		var address = new Address();
		address.setCity(request.getCity());
		address.setStreet(request.getStreet());
		address = addressRepo.save(address);

		var student = new Student();
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setCreatedAt(new Date());
		student.setAddress(address);
		student = studentRepo.save(student);

		if (request.getCourses().size() > 0) {
			var courses = new ArrayList<Course>();
			for (AddCourseRequest course : request.getCourses()) {
				var newCourse = new Course();
				newCourse.setName(course.getName() != null ? course.getName() : "NoName!");
				newCourse.setStudent(student);
				courses.add(newCourse);
			}
			courseRepo.saveAll(courses);
			student.setCourses(courses);
		}		

		logger.info("Successfully created new Student");
		return student;
	}

	public Student updateStudent(Long id, UpdateStudentRequest request) {
		var student = studentRepo.findById(id).get();
		student.setLastName(request.getLastName());
		student.setUpdatedAt(new Date());
		student = studentRepo.save(student);
		
		logger.info("Updated Student");
		return student;
	}

	public void deleteStudent(Long id) {
		try {
			studentRepo.deleteById(id);
			logger.info("Successfully deleted student with id: " + id);
		}
		catch(Exception ex) {
			logger.error("Failed to delete student with id: " + id, ex);
		}
		
	}

}
