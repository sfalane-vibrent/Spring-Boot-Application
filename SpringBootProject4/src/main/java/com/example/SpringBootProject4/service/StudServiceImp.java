package com.example.SpringBootProject4.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootProject4.binding.Students;
import com.example.SpringBootProject4.repo.StudRepository;

@Service
public class StudServiceImp implements StudService{

    @Autowired	
	private StudRepository studRepo;
    
    @Override
	public String upsert(Students stud) 
    {
		
		studRepo.save(stud); //insert and update depend on primary key
		return "Succees";
	}

    @Override
	public Students getById(Long id) 
    {
		
		Optional<Students> findById=studRepo.findById(id);
		
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

    @Override
	public List<Students> getAllStudents() 
	{
		
		return studRepo.findAll();
		
	}
    @Override
   public String deleteById(Long id) 
	{
		if(studRepo.existsById(id))
		{
			studRepo.deleteById(id);
			return "Delete Successfully";
		}
		return "No Record Found";
	}

	
}

