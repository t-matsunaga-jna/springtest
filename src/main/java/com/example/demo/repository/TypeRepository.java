package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PaymentTypeModel;

@Repository
public interface TypeRepository extends JpaRepository<PaymentTypeModel,String> {
	List<PaymentTypeModel> findByType1AndType2(String type1,String type2);
}
