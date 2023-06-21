package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.service.UserService;

@Controller
public class HomeController {

//	@Autowired

	private UserService userService;

	public HomeController(UserService userService) {
		System.out.println("Constructor injection");
		this.userService = userService;
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/createUser")
	public String registerUser() {
		String msg = userService.saveUser();
		System.out.println(msg);
		return "success";
	}

	/*
	 * @RequestMapping("/home") public String home() { return "home"; }
	 * 
	 * @RequestMapping("/about") public String about() { return "about"; }
	 */

}
