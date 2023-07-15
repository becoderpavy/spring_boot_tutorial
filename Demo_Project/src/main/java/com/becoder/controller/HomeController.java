package com.becoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

	@GetMapping("/failed")
	public String failed() {
		//System.out.println("Failure");
		return "failed";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "login"; 
	}
	
	@GetMapping("/logouts")
	public String logout() {
		return "logout"; 
	}

}
