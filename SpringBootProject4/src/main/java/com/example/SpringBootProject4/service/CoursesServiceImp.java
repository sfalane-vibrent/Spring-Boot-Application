package com.example.SpringBootProject4.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootProject4.binding.Courses;
import com.example.SpringBootProject4.repo.CoursesRepository;


@Service
public class CoursesServiceImp implements CourseService {

	@Autowired
    private  CoursesRepository coursesRepository;

    
    @Override
    public String upsert(Courses course) {
        coursesRepository.save(course);
        return "Success";
    }

    @Override
    public Courses getById(Long id) {
        Optional<Courses> findById = coursesRepository.findById(id);
        return findById.orElse(null);
    }
    
    

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if (coursesRepository.existsById(id)) {
            coursesRepository.deleteById(id);
            return "Delete Successfully";
        }
        return "No Record Found";
    }
}

