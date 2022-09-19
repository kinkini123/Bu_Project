package com.bookinginfoservice.service;

import java.util.List;
import java.util.Optional;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinginfoservice.model.Booking;
import com.bookinginfoservice.model.Ticket;
import com.bookinginfoservice.model.UserModel;
import com.bookinginfoservice.model.UserModel;
import com.bookinginfoservice.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private TicketRepository trepo;

	public Optional<Ticket> finById(String id) {
		// TODO Auto-generated method stub
		return trepo.findById(id);
	}

	public Ticket save(Ticket ticket) {
		Ticket t = trepo.save(ticket);
		return t;
	}

//	public void save(UserModel user) {
//		trepo.save(user);
//	}
//
//	public void save(Booking[] b) {
//	trepo.save(b);
//	}
	

	public Iterable<Ticket> findAllDetails() {
		// TODO Auto-generated method stub
		return trepo.findAll() ;
	}

	public Ticket findTicketByemailId(String emailId) {
		// TODO Auto-generated method stub
		return trepo.findTicketByemailId(emailId);
	}

	
	

	

}
