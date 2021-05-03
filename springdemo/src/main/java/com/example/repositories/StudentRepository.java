package com.example.repositories;

import java.util.List;

import com.example.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JpaRepository is a combination of CrudRepo and PagingAndSortingRepository

    // JPA supports default methods for properties, funkar även för singel
    List<Student> findByFirstName(String firstName);

    List<Student> findByLastNameAndFirstName(String lastName, String firstName);

    List<Student> findByLastNameOrFirstName(String lastName, String firstName);

}
