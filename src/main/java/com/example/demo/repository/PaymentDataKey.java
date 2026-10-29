package com.example.demo.repository;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class PaymentDataKey implements Serializable{
	
	@Getter
	@Setter
	private String UID;
	
	@Getter
	@Setter
	private String No;
}
