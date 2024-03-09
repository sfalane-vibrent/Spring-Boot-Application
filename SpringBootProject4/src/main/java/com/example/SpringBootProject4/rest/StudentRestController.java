package com.example.SpringBootProject4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBootProject4.binding.Students;
import com.example.SpringBootProject4.service.StudServiceImp;

@RestController
public class StudentRestController {

    @Autowired
    private StudServiceImp studService;

    @RequestMapping(value = "${endpoint.student.create}", method = RequestMethod.POST)
    public ResponseEntity<String> createStudent(@RequestBody Students stud) {
        String status = studService.upsert(stud);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @RequestMapping(value = "${endpoint.student.getOne}", method = RequestMethod.GET)
    public ResponseEntity<Students> getStudent(@PathVariable Long id) {
        Students s = studService.getById(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.student.getAll}", method = RequestMethod.GET)
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> allStudents = studService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.student.update}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStudent(@RequestBody Students stud) {

        String status = studService.upsert(stud);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "${endpoint.student.delete}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        String status = studService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
