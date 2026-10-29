package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.example.demo.repository.PaymentDataKey;

@Entity
@Table(name="payment_data")
@IdClass(value =PaymentDataKey.class)
public class PaymentDataModel {
	
	@Id
	private String UID;
	
	@Id
	private String No;
	
	private String type1;
	
	private String type2;
	
	private Date date;
	
	private String message;
	
	private int price;
	
	private boolean del_Flag;
	
	private LocalDateTime createdate;
	
	private String type = type1 + type2;
	
	private String typeName;
	
	//getter
	
	public String getUID() {
		return this.UID;
	}
	
	public String getNo() {
		return this.No;
	}
	
	public String getType1() {
		return this.type1;
	}
	
	public String getType2() {
		return this.type2;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public boolean getDelFlag() {
		return this.del_Flag;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	//setter
	
	public void setUID(String UID) {
		this.UID = UID;
	}
	
	public void setNo(String No) {
		this.No = No;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setDelFlag(boolean del_flag) {
		this.del_Flag = del_flag;
	}
	
	// 項目名取得
	/*
	@Autowired
	private TypeRepository typerepository; 
	
	public void setTypeName() {
		this.typeName = typerepository.findByType1AndType2(type1, type2).getFirst().getName();
	}
	*/

}
