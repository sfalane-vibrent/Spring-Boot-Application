package com.example.SpringBootProject4.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootProject4.binding.Courses;
import com.example.SpringBootProject4.binding.StudentCourses;
import com.example.SpringBootProject4.binding.Students;
import com.example.SpringBootProject4.repo.CoursesRepository;
import com.example.SpringBootProject4.repo.StudRepository;
import com.example.SpringBootProject4.repo.StudentCoursesRepository;

@Service
public class StudentCoursesServiceImp implements StudentCoursesService {

    @Autowired
    private StudentCoursesRepository studentCoursesRepository;
    
    
    @Autowired
    private StudRepository studRepository;
    
    @Autowired
    private CoursesRepository coursesRepository;
    
    
    @Override
    public String upsert(StudentCourses studentcourses)
    {
      
    	  if(Objects.nonNull(studentcourses.getStudent()) || studentcourses.getCourse() == null)
    	       // studentcourses.getStudent().getStudentId() == null || studentcourses.getCourse().getCourseId() == null) 
    	   {
    	        return "Error: Required data is missing.";
    	   }
    	  
    	
    	    Students student = studentcourses.getStudent();
    	    Courses course = studentcourses.getCourse();
    	    
    	    if (student.getStudentId() == null || !studRepository.existsById(student.getStudentId())) 
    	    {
    	        //studRepository.save(student);
    	    	return "This student record does not exist in Students table";
    	    }

  
    	    if (course.getCourseId() == null || !coursesRepository.existsById(course.getCourseId())) 
    	    {
    	        //coursesRepository.save(course);
    	    	return "This course does not exist in Courses table";
    	    }

    	
    	   /* if (!studentCoursesRepository.existsBy(studentcourses.getId())) 
    	    {
    	        studentCoursesRepository.save(studentcourses);
    	        return "Success";
    	    } else 
    	    {
    	        return "Record already exists.";
    	    }*/
    	  
    	  studentCoursesRepository.save(studentcourses);
	        return "Success";
    	}
    	

   


	  @Override
	    public StudentCourses getById(Long id) 
	    {
	        Optional<StudentCourses> findById = studentCoursesRepository.findById(id);
	        
	        return findById.orElse(null);
	    }
	  
	    @Override
	    public List<StudentCourses> getAllStudentsCourses() 
	    {
	        return studentCoursesRepository.findAll();
	    }
	    
	    
	    @Override
	    public String deleteById(Long id) 
	    {
	        if (studentCoursesRepository.existsById(id)) 
	        {
	            studentCoursesRepository.deleteById(id);
	            return "Delete Successfully";
	        }
	        return "No Record Found";
	    }
     
   /* @Override
    public boolean hasStudentCompletedCourse(Long studentId, Long courseId) 
    {
        
        if (studentCoursesRepository.existsByStudentIdAndCourseId(studentId, courseId)) 
        {
           return true;
        }

       return false;
    }*/
	
}
