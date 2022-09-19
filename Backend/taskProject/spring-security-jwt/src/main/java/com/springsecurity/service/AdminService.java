package com.springsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.springsecurity.models.Booking;
import com.springsecurity.models.Ticket;
import com.springsecurity.models.TicketStore;
import com.springsecurity.models.Train;
import com.springsecurity.models.UserModel;
@Service
public class AdminService {
	
	@Autowired
	private RestTemplate resttemplate;
	
	public UserModel insertAdmin(@RequestBody UserModel admin) {
	UserModel u = resttemplate.postForObject("http://localhost:8089/admin/i", admin, UserModel.class);
	return u;
	}
	
	public List<UserModel> getAllAdminlDetails(){
		List<UserModel>  u= resttemplate.getForObject("http://localhost:8089/admin/g", List.class);
		return u;
		
		
	}
	public Train insertTrain(@RequestBody Train train)
	{
		Train t= resttemplate.postForObject("http://localhost:8031/traindetails/i", train, Train.class);
		return t;
	}
	
	public Ticket insertTicketInfo(@RequestBody Ticket ticket) {
		Ticket ti = resttemplate.postForObject("http://localhost:8041/ticket/i", ticket, Ticket.class);
		return ti;
	}
	
	
	public TicketStore fullBookingDetails( String emailId) {
		
		TicketStore t= resttemplate.getForObject("http://localhost:8041/ticket/ga/fullBookingDetails/{emailId}", TicketStore.class,emailId);
		
		return t;
		
		
	}

	public List<Booking> getAllBookingDetails(){
		List<Booking>  b= resttemplate.getForObject("http://localhost:8089/admin/t", List.class);
		return b;
		
		
	}	
//	public UserModel findByEmailId(String emailId) {
//		RestTemplate r = new RestTemplate();
//		System.out.println("hi 23565");
//		UserModel op = r.getForObject("http://localhost:8089/admin/getAll/"+emailId,UserModel.class);
//		
//	
//		return op;
//		
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
