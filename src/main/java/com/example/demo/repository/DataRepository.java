package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PaymentDataModel;

@Repository
public interface DataRepository extends JpaRepository<PaymentDataModel,PaymentDataKey>{
	List<PaymentDataModel>findByUIDOrderByDate(String UID);
	
	List<PaymentDataModel>findByUIDOrderByType1AndType2(String UID);
}
