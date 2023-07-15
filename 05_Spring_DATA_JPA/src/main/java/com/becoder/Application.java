package com.becoder;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.becoder.entites.Student;
import com.becoder.repository.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		StudentRepo stRepo = context.getBean(StudentRepo.class);

//		Student st = new Student();
//		st.setName("Pavy");
//		st.setAddress("UK");

		// stRepo.save(st);

		// List<Student> list = (List<Student>) stRepo.findAll();

		// list.forEach(student -> System.out.println(student));
		// Student st = stRepo.findById(1).get();
		// System.out.println(st);

		/*
		 * st.setName("Becoder Kumar"); st.setAddress("London");
		 * 
		 * Student updatedStudent = stRepo.save(st);
		 * 
		 * System.out.println("Updated Data"); System.out.println(updatedStudent);
		 */

		// stRepo.delete(st);
		// System.out.println("Delete sucessfully");

		// get student by name

		/*
		 * Student st = stRepo.findByName("Rakesh Das"); System.out.println(st);
		 */

		// get student by address
		/*
		 * Student st = stRepo.findByAddress("UK"); System.out.println(st);
		 */

		// get student by and using
		// Student st = stRepo.findByNameAndAddress("Pavy Kumar", "UK");
		/*
		 * List<Student> st = stRepo.findByNameOrAddress("Pavy Kumar", "UK");
		 * st.forEach(e->System.out.println(e));
		 */
		// List<Student> st = stRepo.findByAddressIsNull();
		/*
		 * List<Student> st = stRepo.findByAddressIsNotNull(); st.forEach(e ->
		 * System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameLike("Rajesh"); st.forEach(e ->
		 * System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameStartingWith("P"); st.forEach(e ->
		 * System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameContaining("a"); st.forEach(e ->
		 * System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByOrderByNameDesc(); st.forEach(e ->
		 * System.out.println(e));
		 */

		/*
		 * Boolean f = stRepo.existsByName("Demo"); System.out.println(f);
		 */

		// custom query using
		/*
		 * Student st = stRepo.getStudentByNameAndAddress("Pavy", "LONDON");
		 * System.out.println(st);
		 */

		/*
		 * List<Student> st = stRepo.searchname("UK"); st.forEach(e ->
		 * System.out.println(e));
		 */

		// pagination
		Sort sort = Sort.by("id").descending();

		List<Student> listSortStudent = stRepo.findAll(sort);

		System.out.println("-----------sorting student details--------");
		listSortStudent.forEach(e->System.out.println(e));
		System.out.println("------------------------");
		
		Pageable pageable = PageRequest.of(1, 3, sort);

		Page<Student> page = stRepo.findAll(pageable);

		page.get().forEach(e -> System.out.println(e));
		System.out.println("Size=" + page.getSize());
		System.out.println("Elements=" + page.getTotalElements());
		System.out.println("Pages=" + page.getTotalPages());

	}

}
