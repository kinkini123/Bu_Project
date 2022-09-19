package com.handlerinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handlerinfo.model.UserModel;
import com.handlerinfo.model.Train;
import com.handlerinfo.repository.AdminRepository;


@Service
public class AdminServices {
	@Autowired
	AdminRepository adminrepo;
	

	public Optional<UserModel> findById(int id) {
		// TODO Auto-generated method stub
		return adminrepo.findById(id);
	}


	public UserModel save(UserModel admin) {
		// TODO Auto-generated method stub
		UserModel a= adminrepo.save(admin);
		return a;
	}


	public void deleteById(int id) {
		// TODO Auto-generated method stub
		adminrepo.deleteById(id);
		
	}


	public Train saveTrain(Train train) {
		Train t=adminrepo.save(train);
		return t;
		
	}


	public Iterable<UserModel> findAllDetails() {
		// TODO Auto-generated method stub
		return adminrepo.findAll();
	}
	
	public UserModel findByemailId(String emailId) {
		// TODO Auto-generated method stub
		return adminrepo.findByemailId(emailId);
	}
	

}
