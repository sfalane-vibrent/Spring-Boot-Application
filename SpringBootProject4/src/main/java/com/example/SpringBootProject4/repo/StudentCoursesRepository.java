package com.example.SpringBootProject4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootProject4.binding.Courses;
import com.example.SpringBootProject4.binding.StudentCourses; // Add import statement
import com.example.SpringBootProject4.binding.Students;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Long> 
{

   //  boolean existsByStudentAndCourse(Students student, Courses course);
   // //boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);
}