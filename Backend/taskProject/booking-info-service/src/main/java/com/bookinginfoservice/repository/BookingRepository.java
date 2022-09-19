package com.bookinginfoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookinginfoservice.model.Booking;


@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

	
	@Query("{'emailId':?0}")
	Booking findByemailId(String emailId);
}
