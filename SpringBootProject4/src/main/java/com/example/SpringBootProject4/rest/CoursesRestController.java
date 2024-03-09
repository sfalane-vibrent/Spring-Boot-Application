package com.example.SpringBootProject4.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBootProject4.binding.Courses;
import com.example.SpringBootProject4.service.CoursesServiceImp;

@RestController
public class CoursesRestController {

    @Autowired
    private CoursesServiceImp courseService;

    @RequestMapping(value = "${endpoint.courses.create}", method = RequestMethod.POST)
    public ResponseEntity<String> createCourse(@RequestBody Courses course)
    {
        String status = courseService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @RequestMapping(value = "${endpoint.courses.getOne}", method = RequestMethod.GET)
    public ResponseEntity<Courses> getCourse(@PathVariable Long id) {
        Courses course = courseService.getById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.courses.getAll}", method = RequestMethod.GET)
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> allCourses = courseService.getAllCourses();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.courses.update}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCourse(@RequestBody Courses course) {
        String status = courseService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.courses.delete}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        String status = courseService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
