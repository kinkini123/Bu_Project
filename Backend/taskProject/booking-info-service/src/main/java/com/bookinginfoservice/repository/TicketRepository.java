package com.bookinginfoservice.repository;

import org.bson.json.JsonObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookinginfoservice.model.Booking;
import com.bookinginfoservice.model.Ticket;
import com.bookinginfoservice.model.UserModel;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

//	void save(UserModel[] user);
//
//	void save(Booking[] b);
	
	@Query("{'emailId':?0}")
	Ticket findTicketByemailId(String emailId);


	

}