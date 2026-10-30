package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@Controller
public class ConfigUserController {
	private UserService userService;
	private UserModel userModel;

	@GetMapping("/configUser")
	public String configUser(Model model) {
		return "config_user";
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String processEditUser (@RequestParam("name") String name,
			                       @RequestParam("income") int income,
			                       Model model) {
		if (name.isEmpty()) {
			model.addAttribute("exe",false);
			return "edit_user";
		} else {
			if (name.isBlank()) {
				model.addAttribute("exe",false);
				return "edit_user";
			} else {
				// ユーザーデータ登録
				UserModel saveUser = new UserModel();
				saveUser.setUID(userModel.getUID());
				saveUser.setId(userModel.getId());
				saveUser.setPassword(userModel.getPassword());
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
