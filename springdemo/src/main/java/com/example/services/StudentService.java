package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
public class StudentService {

	Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentSqlRepository studentRepo;

	@Autowired
	private AddressSqlRepository addressRepo;

	@Autowired
	private CourseSqlRepository courseRepo;

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

		logger.info("Created new student: " + student.toString());
		return student;
	}

	public Student updateStudent(Long id, UpdateStudentRequest request) {
		var student = studentRepo.findById(id).get();
		student.setLastName(request.getLastName());
		student.setUpdatedAt(new Date());
		logger.info("Updated Student");
		return studentRepo.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
		logger.info("Deleted student with Id: " + id);
	}

}
