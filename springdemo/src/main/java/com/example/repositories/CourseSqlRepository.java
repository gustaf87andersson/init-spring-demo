package com.example.repositories;

import com.example.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSqlRepository extends JpaRepository<Course, Long> {
    
}
