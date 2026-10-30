package com.example.demo.service;

import com.example.demo.model.PaymentDataModel;
import com.example.demo.model.PaymentTypeModel;
import com.example.demo.repository.TypeRepository;

public class GetTypeAllName {
	
	
	private TypeRepository typeRepository;
	
	// 選択肢用作成
	public String getTypeChoice(PaymentTypeModel model) {	
		String type1Name = typeRepository.findByType1AndType2(model.getType1(), "00").getFirst().getName();
		
		if (model.getType2() == "00") {
			return model.getType1() + " " + model.getName() + model.getType2() + " --";
		} else {
			
			return model.getType1() + " " + type1Name + model.getType2() + " " + model.getName();
		}
	}
	
	public String getTypeFullName(PaymentDataModel model) {
		String type1Name = typeRepository.findByType1AndType2(model.getType1(), "00").getFirst().getName();
		String type2Name = typeRepository.findByType1AndType2(model.getType1(), model.getType2()).getFirst().getName();
		
		if (model.getType2() == "00") {
			return model.getType1() + " " + type1Name + model.getType2() + " --";
		} else {
			
			return model.getType1() + " " + type1Name + model.getType2() + " " + type2Name;
		}
	}
}
