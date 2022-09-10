package com.example.EmpSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmpSystem.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee , Integer>{

	
}
