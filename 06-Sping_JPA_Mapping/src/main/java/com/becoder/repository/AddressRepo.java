package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Address;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
