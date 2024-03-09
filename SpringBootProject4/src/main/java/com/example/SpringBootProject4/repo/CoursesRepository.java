package com.example.SpringBootProject4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SpringBootProject4.binding.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long>
{
 
}