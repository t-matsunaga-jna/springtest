package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String main(Model model) {
		return "main";
	}
	
	@GetMapping("/editData")
	public String editData(Model model) {
		return "edit_data";
	}
	
	@GetMapping("/viewMonth")
	public String viewMonth(Model model) {
		return "view_month";
	}
	
	@GetMapping("/viewYear")
	public String viewYear(Model model) {
		return "view_year";
	}
	
	@GetMapping("/compareData")
	public String compareData(Model model) {
		return "compare_data";
	}
	
	@GetMapping("/configUser")
	public String configUser(Model model) {
		return "config_user";
	}
}
