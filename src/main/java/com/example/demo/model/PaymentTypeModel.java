package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_tipe")
public class PaymentTypeModel {
	
	@Id
	private String No;
	
	private String type1;
	
	private String type2;
	
	private String name;
	
	private boolean del_Frag;
	
	private LocalDateTime createData = LocalDateTime.now();
	
	//getter
	
	public String getNo() {
		return this.No;
	}
	
	public String getType1() {
		return this.type1;
	}
	
	public String getType2() {
		return this.type2;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getDelFlag() {
		return this.del_Frag;
	}
	
	//setter
	
	public void setNo(String No) {
		this.No = No;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDelFlag(boolean delFlag) {
		this.del_Frag = delFlag;
	}

}
