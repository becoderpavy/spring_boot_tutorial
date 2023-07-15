package com.becoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.becoder.entity.Category;
import com.becoder.entity.Product;
import com.becoder.repository.AddressRepo;
import com.becoder.repository.CategoryRepo;
import com.becoder.repository.EmpRepo;
import com.becoder.repository.MobileRepo;
import com.becoder.repository.ProductRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private MobileRepo mobileRepo;

	@Autowired
	private AddressRepo addRepo;

	@Autowired
	private CategoryRepo cateRepo;

	@Autowired
	private ProductRepo pRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Emp emp = new Emp(); emp.setEmpName("Pavy");
		 * 
		 * Mobile mb = new Mobile(); mb.setMobilename("Iphone 13");
		 * 
		 * //emp.setMobile(mb); mb.setEmp(emp);
		 * 
		 * empRepo.save(emp); mobileRepo.save(mb);
		 * 
		 * System.out.println("Save sucess");
		 */

		/*
		 * Emp emp = empRepo.findById(1).get(); System.out.println("Name=" +
		 * emp.getEmpName()); System.out.println("mobile=" +
		 * emp.getMobile().getMobilename());
		 */

		/*
		 * Mobile mb=mobileRepo.findById(4).get(); System.out.println("Emp Name=" +
		 * mb.getEmp().getEmpName()); System.out.println("mobile=" +
		 * mb.getMobilename());
		 */
		// onetoMany manytoone

		/*
		 * Emp emp = new Emp(); emp.setEmpName("Rejesh kumar");
		 * 
		 * Address ad = new Address(); ad.setAddress("Odisha");
		 * ad.setType("Permanent address"); ad.setEmp(emp);
		 * 
		 * Address ad2 = new Address(); ad2.setAddress("Pune");
		 * ad2.setType("Current address"); ad2.setEmp(emp);
		 * 
		 * List<Address> addList = Arrays.asList(ad, ad2); emp.setAddress(addList);
		 * 
		 * empRepo.save(emp); System.out.println("Save Success");
		 */

		/*
		 * Emp emp = empRepo.findById(7).get();
		 * 
		 * System.out.println("Emp name=" + emp.getEmpName());
		 * emp.getAddress().forEach(e -> System.out.println(e.getAddress() + "=" +
		 * e.getType()));
		 */

		/*
		 * Address ad = addRepo.findById(11).get(); System.out.println("Address=" +
		 * ad.getAddress()); System.out.println("Emp Name=" + ad.getEmp().getEmpName());
		 */
//many to many
		/*
		 * Category ca1 = new Category(); ca1.setCategoryname("Electronics");
		 * 
		 * Category ca2 = new Category(); ca2.setCategoryname("Mobile");
		 * 
		 * Product p1 = new Product(); p1.setProductname("TV");
		 * 
		 * Product p2 = new Product(); p2.setProductname("Oneplus mobile");
		 * 
		 * Product p3 = new Product(); p3.setProductname("Iphone 14");
		 * 
		 * ca1.getProducts().add(p1); ca1.getProducts().add(p2);
		 * ca1.getProducts().add(p3);
		 * 
		 * ca2.getProducts().add(p2); ca2.getProducts().add(p3);
		 * 
		 * p1.getCategories().add(ca1); p2.getCategories().add(ca1);
		 * p3.getCategories().add(ca1);
		 * 
		 * p2.getCategories().add(ca2); p3.getCategories().add(ca2);
		 * 
		 * cateRepo.save(ca1); cateRepo.save(ca2);
		 * 
		 * System.out.println("Save success");
		 */

//		Category ca = cateRepo.findById(2).get();
//		System.out.println("Category name="+ca.getCategoryname());
//		ca.getProducts().forEach(e -> System.out.println(e.getProductname()));

		Product p = pRepo.findById(4).get();
		System.out.println("Product name=" + p.getProductname());

		p.getCategories().forEach(e -> System.out.println(e.getCategoryname()));

	}

}
