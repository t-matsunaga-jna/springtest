package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String UID;
	
	private String id;
	
	private String password;
	
	private String name;
	
	private int income;
	
	private String inv1;
	
	private String inv2;
	
	private String sav1;
	
	private String sav2;
	
	private LocalDateTime createdate = LocalDateTime.now();
	
	//getter
	
	public String getUID() {
		return this.UID;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getIncome() {
		return this.income;
	}
	
	public String getInv1() {
		return this.inv1;
	}
	
	public String getInv2() {
		return this.inv2;
	}
	
	public String getSav1() {
		return this.sav1;
	}
	
	public String getSav2() {
		return this.sav2;
	}
	
	public LocalDateTime getCreatedate() {
		return this.createdate;
	}
	
	//setter
	
	public void setUID(String UID) {
		this.UID = UID;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name  = name;
	}
	
	public void setIncome(int income) {
		this.income  = income;
	}
	
	public void setinv1(String inv1) {
		this.inv1  = inv1;
	}
	
	public void setinv2(String inv2) {
		this.inv2 = inv2;
	}
	
	public void setSav1(String sav1) {
		this.sav1  = sav1;
	}
	
	public void setSav2(String sav2) {
		this.sav2  = sav2;
	}

}
