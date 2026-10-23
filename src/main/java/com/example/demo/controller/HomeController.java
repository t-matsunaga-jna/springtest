package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping("/main")
	public String HomePage() {
		return "/main";
	}
	
}
