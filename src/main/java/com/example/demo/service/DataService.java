package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.PaymentDataModel;
import com.example.demo.repository.DataRepository;

@Component
public class DataService {
	@Autowired
	private DataRepository dataRepository;
	
	//データ作成
	public void save (PaymentDataModel data) {
		dataRepository.save(data);
	}
	
	//削除
	public void delete (PaymentDataModel data) {
		data.setDelFlag(true);
		dataRepository.save(data);
	}
	
}
