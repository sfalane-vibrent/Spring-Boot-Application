package com.example.SpringBootProject4.service;

import java.util.List;

import com.example.SpringBootProject4.binding.Students;

public interface StudService
{

	public String upsert(Students stud);  //save and update
	
	public Students getById(Long id);
	
	public List<Students> getAllStudents();
	
	public String deleteById(Long id);


}
