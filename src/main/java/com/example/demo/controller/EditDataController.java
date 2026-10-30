package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PayDataModel;
import com.example.demo.model.PaymentDataModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.DataService;
import com.example.demo.service.GetTypeAllName;

@Controller
public class EditDataController {
	private UserModel userModel;
	private DataService dataService;
	
	@GetMapping("/editData")
	public String editData(Model model) {
		return "edit_data";
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String processEditData (@RequestParam("date") String date,
			                       @RequestParam("type1") String type1,
			                       @RequestParam("type2") String type2,
			                       @RequestParam("name") String message,
			                       @RequestParam("price") int price,
			                       Model model) {
		try {
		// ユーザー情報
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		userModel = (UserModel)auth.getPrincipal();
		
		// 支出データ取得
		List<PaymentDataModel> payDataModel = dataService.get(userModel.getUID());
		
		// データ登録
		PaymentDataModel savePayModel = new PaymentDataModel();
		
		savePayModel.setUID(userModel.getUID());
		
		int count = payDataModel.size() + 1;
		savePayModel.setNo(String.valueOf(count + 1000000) .substring(1, 6));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
		savePayModel.setDate(LocalDate.parse(date, formatter));
		
		savePayModel.setType1(type1.substring(0, 2));
		savePayModel.setType2(type2.substring(0, 3));
		savePayModel.setMessage(message);
		savePayModel.setPrice(price);
		savePayModel.setDelFlag(false);
		
		dataService.save(savePayModel);
		
		// 当月取得
		String month = LocalDate.now().getMonth().toString() + "月";
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD"); 
		GetTypeAllName getTypeName = new GetTypeAllName();
		List<PayDataModel> list = new ArrayList<>();
		for (int i=0; i < payDataModel.size(); i++) {
			PayDataModel payModel = new PayDataModel();
			PaymentDataModel pay= payDataModel.get(i); 
			
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
		} catch (Exception e){
			model.addAttribute("exe",false);
			return "editData";
		}
	}
}
