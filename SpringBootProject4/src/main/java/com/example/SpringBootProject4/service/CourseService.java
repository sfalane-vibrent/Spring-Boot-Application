package com.example.SpringBootProject4.service;

import java.util.List;

import com.example.SpringBootProject4.binding.Courses;
import com.example.SpringBootProject4.binding.Students;

public interface CourseService {
	

		public String upsert(Courses course);  //save and update
		
		public Courses getById(Long id);
		
		public List<Courses> getAllCourses();
		
		public String deleteById(Long id);


	}



