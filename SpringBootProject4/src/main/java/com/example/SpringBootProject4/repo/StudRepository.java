package com.example.SpringBootProject4.repo;

import com.example.SpringBootProject4.binding.Students; // Add import statement

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepository extends JpaRepository<Students, Long> {
	
	
    
}
