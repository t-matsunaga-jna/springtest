package com.example.demo.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@Controller
public class EditUserController {
	private UserService userService;
	
	@GetMapping("/editUser")
	public String editData(Model model) {
		return "edit_user";
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String processEditUser (@RequestParam("id") String id,
			                       @RequestParam("password") String password,
			                       @RequestParam("name") String name,
			                       @RequestParam("income") int income,
			                       Model model) {
		if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
			model.addAttribute("exe",false);
			return "edit_user";
		} else {
			if (id.isBlank() || password.isBlank() || name.isBlank()) {
				model.addAttribute("exe",false);
				return "edit_user";
			} else {
				// ユーザーデータ登録
				UserModel saveUser = new UserModel();
				saveUser.setUID(UUID.randomUUID().toString().replace("-", ""));
				saveUser.setId(id);
				saveUser.setPassword(password);
				saveUser.setName(name);
				if (income != 0) {
					saveUser.setIncome(income);
				}
				userService.save(saveUser);				
			}
		}
		return "main";
	}
}
