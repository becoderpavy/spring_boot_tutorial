package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

	public Employee findByEmail(String email);
	
	
}
