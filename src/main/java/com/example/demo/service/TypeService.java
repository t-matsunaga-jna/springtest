package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.PaymentTypeModel;
import com.example.demo.repository.TypeRepository;

public class TypeService {
	@Autowired
	private TypeRepository typeRepository;
	
	public void save(PaymentTypeModel type) {
		typeRepository.save(type);
	}
	
}
