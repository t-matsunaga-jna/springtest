package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/main")
	public String main(Model model) {
		return "main";
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
}
