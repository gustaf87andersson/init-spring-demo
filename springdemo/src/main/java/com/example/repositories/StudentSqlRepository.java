package com.example.repositories;

import java.util.List;

import com.example.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSqlRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByAddressCity(String city);

    @Query("From Student where address.city = :city")
    List<Student> getByAddressCity(String city);

}
