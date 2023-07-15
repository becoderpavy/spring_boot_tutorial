package com.becoder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.becoder.entites.Student;

//public interface StudentRepo extends CrudRepository<Student, Integer> {
public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByName(String name);

	Student findByAddress(String address);

	Student findByNameAndAddress(String nm, String ad);

	@Query("select u from Student u where u.name=?1 and u.address=?2")
	Student getStudentByNameAndAddress(String nm, String ad);

	@Query("select u from Student u where u.address like :ad")
	List<Student> searchname(@Param("ad") String nm);

	@Query("select u from Student u where u.name=:nm or u.address=:ad")
	List<Student> getByNameOrAddress(@Param("nm") String nm, @Param("ad") String ad);

	List<Student> findByNameOrAddress(String nm, String ad);

	List<Student> findByAddressIsNull();

	List<Student> findByAddressIsNotNull();

	List<Student> findByNameLike(String name);

	List<Student> findByNameStartingWith(String ch);

	List<Student> findByNameContaining(String ch);

	List<Student> findByOrderByNameDesc();

	boolean existsByName(String name);

}
