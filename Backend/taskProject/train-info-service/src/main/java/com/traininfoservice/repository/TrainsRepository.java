package com.traininfoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.traininfoservice.model.Train;


@Repository
public interface TrainsRepository extends MongoRepository<Train,String> {
	@Query("{'train_name':?0}")
	Train findByTrainName(String train_name);
}