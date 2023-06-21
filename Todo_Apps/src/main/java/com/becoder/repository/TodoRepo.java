package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entites.Todo;


public interface TodoRepo extends JpaRepository<Todo, Integer> {

}
