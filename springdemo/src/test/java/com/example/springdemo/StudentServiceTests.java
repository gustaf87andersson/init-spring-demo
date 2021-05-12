package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.example.entities.Address;
import com.example.entities.Student;
import com.example.repositories.AddressSqlRepository;
import com.example.repositories.CourseSqlRepository;
import com.example.repositories.StudentSqlRepository;
import com.example.requests.AddCourseRequest;
import com.example.requests.AddStudentRequest;
import com.example.requests.UpdateStudentRequest;
import com.example.services.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentServiceTests {
    
    private StudentService sut;

    private StudentSqlRepository studentRepo;
    private AddressSqlRepository addressRepo;
    private CourseSqlRepository courseRepo;


    @BeforeEach
    void initTests(){
        this.studentRepo = Mockito.mock(StudentSqlRepository.class);
        this.addressRepo = Mockito.mock(AddressSqlRepository.class);
        this.courseRepo = Mockito.mock(CourseSqlRepository.class);

        this.sut = new StudentService(this.studentRepo, this.addressRepo, this.courseRepo);
    }

    @Test
    void StudentService_updateStudent_Success(){
        // ARRANGE
        var student = new Student();
        student.setId(1L);
        student.setFirstName("Tester");
        student.setLastName("Testersson");
        student.setCreatedAt(new Date());
        Optional<Student> studentMock = Optional.of((Student) student);

        when(studentRepo.findById(anyLong())).thenReturn(studentMock);
        when(studentRepo.save(any(Student.class))).thenReturn(student);

        var updateRequest = new UpdateStudentRequest();
        updateRequest.setLastName("Andersson");

        // ACT
        var result = sut.updateStudent(1L, updateRequest);

        // ASSERT
        assertEquals(updateRequest.getLastName(), result.getLastName());
        assertNotNull(result.getUpdatedAt());
    }

    @Test
    void StudentService_addStudent_Success(){

        when(addressRepo.save(any(Address.class))).thenAnswer(i -> i.getArguments()[0]);
        when(studentRepo.save(any(Student.class))).thenAnswer(i -> i.getArguments()[0]);

        var addRequest = new AddStudentRequest();
        addRequest.setFirstName("Tester");
        addRequest.setLastName("Testersson");
        addRequest.setCity("HappyCity");
        addRequest.setStreet("HappyStreet");
        addRequest.setCourses(new ArrayList<AddCourseRequest>());

        // ACT
        var result = sut.addStudent(addRequest);

        // ASSERT
        assertEquals(addRequest.getFirstName(), result.getFirstName());
        assertEquals(addRequest.getLastName(), result.getLastName(), "Lastname did not match");
        assertNotNull(result.getAddress());
        assertEquals(addRequest.getCity(), result.getAddress().getCity());
        assertEquals(addRequest.getStreet(), result.getAddress().getStreet());
        assertNotNull(result.getCreatedAt());
        assertNull(result.getUpdatedAt());
    }

}
