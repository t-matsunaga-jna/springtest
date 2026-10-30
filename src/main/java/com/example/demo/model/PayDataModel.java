package com.example.demo.model;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PayDataModel {
	
	@Getter
	@Setter
	private String date;
	
	@Getter
	@Setter
	private String type;
	
	@Getter
	@Setter
	private String message;
	
	@Getter
	@Setter
	private int price;
}
