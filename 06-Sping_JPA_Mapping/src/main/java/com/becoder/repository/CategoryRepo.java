package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
