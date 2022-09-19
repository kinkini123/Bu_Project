package com.handlerinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.handlerinfo.model.UserModel;

import com.handlerinfo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository urepo;

	public Optional<UserModel> findById(String userId) {
		// TODO Auto-generated method stub
		return urepo.findById(userId);
	}

	public UserModel save(UserModel user) {
		// TODO Auto-generated method stub
		UserModel u = urepo.save(user);
		return u;
	}

	public List<UserModel> findAllDetails() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

	public void deleteById(String userId) {
		// TODO Auto-generated method stub
		urepo.deleteById(userId);
	}

	public UserModel findByemailId(String emailId) {
		// TODO Auto-generated method stub
		return urepo.findByemailId(emailId);
	}

	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return urepo.findByUserName(username);
	}

}