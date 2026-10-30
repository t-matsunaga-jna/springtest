package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PayDataModel;
import com.example.demo.model.PaymentDataModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.DataService;
import com.example.demo.service.GetTypeAllName;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	private UserModel userModel;
	private UserService userService;
	private DataService dataService;
	
	@GetMapping("/main")
	public String HomePage(@RequestParam("Id") String id, @RequestParam("password") String password,Model model) {
		// ユーザー情報
		if (userService.getByIdPass(id, password) != null) {
			userModel = userService.getByIdPass(id, password).get();
		} else {
			return "login";
		}
		// 当月
		String month = LocalDate.now().getMonth().toString() + "月";
		
		// 支出データ
		List<PaymentDataModel> paydataModel = dataService.get(userModel.getUID());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD"); 
		GetTypeAllName getTypeName = new GetTypeAllName();
		List<PayDataModel> list = new ArrayList<>();
		for (int i=0; i < paydataModel.size(); i++) {
			PayDataModel payModel = new PayDataModel();
			PaymentDataModel pay= paydataModel.get(i); 
			
			if(pay.getDate().getMonth() == LocalDate.now().getMonth()) {
				// データセット
				payModel.setDate(dateFormat.format(pay.getDate()));
				payModel.setType(getTypeName.getTypeFullName(pay));
				payModel.setMessage(pay.getMessage());
				payModel.setPrice(pay.getPrice());
				list.add(payModel);
			}
		}
		
		model.addAttribute("user_name",userModel.getName());
		model.addAttribute("month",month);
		model.addAttribute("pay_data",list);
		return "main";
	}
	
				
	
	
}
