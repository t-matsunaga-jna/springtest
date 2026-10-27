package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/editData")
	public String editData() {
		return "edit_data";
	}
	
	@GetMapping("/viewMonth")
	public String viewMonth() {
		return "view_month";
	}
	
	@GetMapping("/viewYear")
	public String viewYear() {
		return "view_year";
	}
	
	@GetMapping("/compareData")
	public String compareData() {
		return "compare_data";
	}
	
	@GetMapping("/configUser")
	public String configUser() {
		return "config_user";
	}
}
