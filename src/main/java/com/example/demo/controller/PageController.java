package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.PayDataModel;
import com.example.demo.model.PayDataMonthModel;
import com.example.demo.model.PayDataYearModel;
import com.example.demo.model.PaymentDataModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.DataService;
import com.example.demo.service.GetTypeAllName;

@Controller
public class PageController {
	private UserModel userModel;
	private DataService dataService;
	
	@GetMapping("/main")
	public String main(Model model) {
		// ユーザー情報
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		userModel = (UserModel)auth.getPrincipal();
		
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
			
			if(pay.getDate().getYear() == LocalDate.now().getYear() && pay.getDate().getMonth() == LocalDate.now().getMonth()) {
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
	
	@GetMapping("/viewMonth")
	public String viewMonth(Model model) {
		String year = LocalDate.now().getYear() + "年";
		
		// 支出データ
		List<PaymentDataModel> paydataModel = dataService.getByType(userModel.getUID());	
		List<PayDataMonthModel> list = new ArrayList<>();
		
		for (int i=0; i < 12; i++) {
			int month = i+1;

			for (int j=0; j < paydataModel.size(); j++) {			
				PaymentDataModel pay= paydataModel.get(j); 
				if (pay.getDate().getYear() == LocalDate.now().getYear() && pay.getDate().getMonthValue() == month) {
					PayDataMonthModel payMonthModel = new PayDataMonthModel();
					String type1 = pay.getType1();
					int price = pay.getPrice();
					paydataModel.remove(j);
					
					for (int k=0; k < paydataModel.size(); k++) {
						if (pay.getType1() == type1) {
							price = price + pay.getPrice();
							paydataModel.remove(k);
						}
					}
					payMonthModel.setMonth(i + "月");
					payMonthModel.setType1(type1);
					payMonthModel.setPrice(price);
					list.add(payMonthModel);
				}
				
			}
		}
		model.addAttribute("year",year);
		model.addAttribute("pay_data",list);
		return "view_month";
	}
	
	@GetMapping("/viewYear")
	public String viewYear(Model model) {
		String year = LocalDate.now().getYear() + "年";
		
		// 支出データ
		List<PaymentDataModel> paydataModel = dataService.getByType(userModel.getUID());	
		List<PayDataYearModel> list = new ArrayList<>();
		
		for (int i=0; i < paydataModel.size(); i++) {			
			PaymentDataModel pay= paydataModel.get(i); 
			if (pay.getDate().getYear() == LocalDate.now().getYear()) {
				PayDataYearModel payYearModel = new PayDataYearModel();
				String type1 = pay.getType1();
				int price = pay.getPrice();
				paydataModel.remove(i);
				
				for (int j=0; j < paydataModel.size(); j++) {
					if (pay.getType1() == type1) {
						price = price + pay.getPrice();
						paydataModel.remove(j);
					}
				}
				payYearModel.setType1(type1);
				payYearModel.setPrice(price);
				list.add(payYearModel);
			}
			
		}
		model.addAttribute("year",year);
		model.addAttribute("pay_data",list);
		return "view_year";
	}
	
	@GetMapping("/compareData")
	public String compareData(Model model) {
		return "compare_data";
	}
	
	@GetMapping("/editType")
	public String editType() {
		return "editType";
	}
}
