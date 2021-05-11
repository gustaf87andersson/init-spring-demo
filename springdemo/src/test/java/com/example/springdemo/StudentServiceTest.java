package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.entities.Student;
import com.example.repositories.AddressSqlRepository;
import com.example.repositories.CourseSqlRepository;
import com.example.repositories.StudentSqlRepository;
import com.example.requests.UpdateStudentRequest;
import com.example.services.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lombok.var;

public class StudentServiceTest {

    private StudentService sut;

    private StudentSqlRepository studentRepository;
    private AddressSqlRepository addressRepository;
    private CourseSqlRepository courseRepository;

    @BeforeEach
    void init() {
        this.studentRepository = Mockito.mock(StudentSqlRepository.class);
        this.addressRepository = Mockito.mock(AddressSqlRepository.class);
        this.courseRepository = Mockito.mock(CourseSqlRepository.class);
        sut = new StudentService(this.studentRepository, this.addressRepository, this.courseRepository);
    }

    @Test
    void updateStudent_success() {
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("firstName");
        student.setLastName("lastName");
        Optional<Student> studentMock = Optional.of((Student) student);
        when(studentRepository.findById(anyLong())).thenReturn(studentMock);

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        var updateRequest = new UpdateStudentRequest();
        updateRequest.setLastName("Andersson");
        var result = sut.updateStudent(1L, updateRequest);

        assertEquals(result.getLastName(), updateRequest.getLastName());
    }
    
}
