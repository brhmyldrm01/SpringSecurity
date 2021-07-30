package com.example.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	@GetMapping("/")
	public String Home() {
		return "Welcome";
	}
	
	
	@GetMapping("/user")
	public String User() {
		return "Welcome User ";
	}
	
	
	
	@GetMapping("/admin")
	public String Admin() {
		return "Welcome Admin";
	}
		
}
