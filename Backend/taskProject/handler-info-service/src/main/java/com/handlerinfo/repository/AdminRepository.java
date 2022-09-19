package com.handlerinfo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.handlerinfo.model.UserModel;
import com.handlerinfo.model.Train;

public interface AdminRepository extends MongoRepository<UserModel, Integer> {

	Train save(Train train);
	@Query("{'emailId':?0}")
	UserModel findByemailId(String emailId);
}
