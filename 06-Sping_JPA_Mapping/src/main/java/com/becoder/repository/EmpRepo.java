package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>{

}
