package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// ユーザー作成
	public void save(String id,String password, String name) {
		UserModel user = new UserModel();
		user.setId(UUID.randomUUID().toString());
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		
		userRepository.save(user);
	}
	
	// UID検索
	public Optional<UserModel> getUser(String UID) {
		return userRepository.findById(UID);
	}
	
	public List<UserModel> getByIdPass(String id,String pass) {
		return userRepository.findByIdAndPassword(id, pass);
	}
	
	// 削除
	public void delete(String UID) {
		UserModel user = userRepository.findById(UID).orElse(null);
		
		if(user != null) {
			userRepository.delete(user);
		}
	}
	
	// 更新
	public void saveUser(UserModel user) {
		userRepository.save(user);
	}
}
