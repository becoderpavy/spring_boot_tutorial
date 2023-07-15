package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
