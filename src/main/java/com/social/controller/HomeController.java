package com.social.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
	
	@GetMapping
	public String homeControllerHandler() {
		return "this is home controller";
	}
	
	@GetMapping("/home")
	public String homeControllerHandler2() {
		return "this is home controller 2";
	}
	
	@GetMapping("/codewithzosh")
	public String homeControllerHandler3() {
		return "hello codewithzosh";
	}
	
//@PutMapping
//@PostMapping
//	@DeleteMapping
	
}