package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigUserController {

	@GetMapping("/configUser")
	public String configUser(Model model) {
		return "config_user";
	}
}
