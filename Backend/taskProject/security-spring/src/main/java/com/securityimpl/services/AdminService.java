package com.securityimpl.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.securityimpl.models.Booking;
import com.securityimpl.models.Ticket;
import com.securityimpl.models.TicketStore;
import com.securityimpl.models.Train;
import com.securityimpl.models.UserModel;
@Service
public class AdminService {
	public List<Booking> getBookingInfo(){
		RestTemplate r=new RestTemplate();
		return r.getForObject("http://localhost:8032/admin/b", List.class);
	}
	public List<UserModel> getAllAdminlDetails(){
		RestTemplate r=new RestTemplate();
		List<UserModel>  u= r.getForObject("http://localhost:8032/admin/g", List.class);
		return u;
		
		
	}
	public Train insertTrain(@RequestBody Train train)
	{RestTemplate r=new RestTemplate();
		Train t= r.postForObject("http://localhost:8032/admin/i/t", train, Train.class);
		return t;
	}
	
	public Ticket insertTicketInfo(@RequestBody Ticket ticket) {
		RestTemplate r=new RestTemplate();
	
		Ticket ti = r.postForObject("http://localhost:8032/admin/p/ti", ticket, Ticket.class);
		return ti;
	}
	
	
	public TicketStore fullBookingDetails(@PathVariable("id") int id) {
		
		RestTemplate r=new RestTemplate();
		
		TicketStore t= r.getForObject("http://localhost:8041/ticket/ga/fullBookingDetails/{id}", TicketStore.class,id);
		
		return t;
}
}
