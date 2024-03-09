package com.example.SpringBootProject4.service;

import java.util.List;

import com.example.SpringBootProject4.binding.StudentCourses;
import com.example.SpringBootProject4.binding.Students;

public interface StudentCoursesService {
	

		public String upsert(StudentCourses studentCourses);  //save and update
		
		public StudentCourses getById(Long id);
		
		public List<StudentCourses> getAllStudentsCourses();
		
		public String deleteById(Long id);
		
		//public boolean hasStudentCompletedCourse(Long studentId, Long courseId);


	


}
