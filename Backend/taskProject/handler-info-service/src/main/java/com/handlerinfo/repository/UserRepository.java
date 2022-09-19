package com.handlerinfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.handlerinfo.model.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {

	



	@Query("{'emailId':?0}")
	UserModel findByemailId(String emailId);
	@Query("{'username':?0}")
	UserModel findByUserName(String username);
}
