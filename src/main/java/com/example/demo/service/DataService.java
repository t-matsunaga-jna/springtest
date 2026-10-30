package com.example.demo.service;

import java.util.List;

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
	
	// データ取得(日付昇順)
	public List<PaymentDataModel> get (String UID) {
		return dataRepository.findByUIDOrderByDate(UID);
	}
	
	// データ取得(項目昇順)
	public List<PaymentDataModel> getByType (String UID) {
		return dataRepository.findByUIDOrderByType1AndType2(UID);
	}
	
	//削除
	public void delete (PaymentDataModel data) {
		data.setDelFlag(true);
		dataRepository.save(data);
	}
	
}
