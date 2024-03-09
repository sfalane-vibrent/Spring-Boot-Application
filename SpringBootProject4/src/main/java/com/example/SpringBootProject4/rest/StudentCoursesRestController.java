package com.example.SpringBootProject4.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBootProject4.binding.StudentCourses;
import com.example.SpringBootProject4.service.StudentCoursesServiceImp;

@RestController
public class StudentCoursesRestController {

    @Autowired
    private StudentCoursesServiceImp studentCoursesService;

    @RequestMapping(value = "${endpoint.studentCourses.create}", method = RequestMethod.POST)
    public ResponseEntity<String> createStudentCourse(@RequestBody StudentCourses studentCourses) {
        String status = studentCoursesService.upsert(studentCourses);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }


    @RequestMapping(value = "${endpoint.studentCourses.getOne}", method = RequestMethod.GET)
    public ResponseEntity<StudentCourses> getStudentCourse(@PathVariable Long id)
    {
        StudentCourses studentCourses = studentCoursesService.getById(id);
        return new ResponseEntity<>(studentCourses, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.studentCourses.getAll}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentCourses>> getAllStudentCourses() 
    {
        List<StudentCourses> allStudentCourses = studentCoursesService.getAllStudentsCourses();
        return new ResponseEntity<>(allStudentCourses, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.studentCourses.update}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStudentCourse(@RequestBody StudentCourses studentCourses)
    {
        String status = studentCoursesService.upsert(studentCourses);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.studentCourses.delete}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentCourse(@PathVariable Long id)
    {
        String status = studentCoursesService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
