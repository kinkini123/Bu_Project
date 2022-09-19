package com.bookinginfoservice.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookinginfoservice.model.Booking;
import com.bookinginfoservice.model.Ticket;
import com.bookinginfoservice.model.TicketStore;
import com.bookinginfoservice.model.UserModel;
import com.bookinginfoservice.service.TicketService;

@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService tservice;
	@Autowired
	RestTemplate resttemplate;

	@PostMapping("/{i}")
	public Ticket insertBooking(@RequestBody Ticket ticket) {
		String t = ticket.getEmailId();
//		Optional<Ticket> op = tservice.finById(ticket.getId());
		Booking b = resttemplate.getForObject("http://localhost:8041/bookingdetails/getAllBooking/" + t, Booking.class);
		String id1 = b.getId();
		ticket.setId(id1);

		System.out.println("Data saved !!");
		Ticket t1 = tservice.save(ticket);

		System.out.println(t);
		return t1;
	}

	@GetMapping("/ga/{id}")
	public Ticket getAllTicketDetailById(@PathVariable("id") String id) {
		Optional<Ticket> op = tservice.finById(id);
		// Booking b =
		// resttemplate.getForObject("http://localhost:8041/bookingdetails/g",
		// Booking.class,id);

		Ticket t = op.get();
		return t;

	}

//	@GetMapping("/ga/{id}")
//	public Ticket getAllTicketDetailById(@PathVariable("id") int id){
//		
//	//Booking	b = resttemplate.getForObject("http://localhost:8041/bookingdetails/g", Booking.class,id);
//	Optional<Ticket> op=tservice.findById(id);
//		Ticket t=op.get();
//		return t;
//	}
	@GetMapping("/g")
	public List<Ticket> getAllTicketDetails() {
		List<Ticket> list = new ArrayList();
		tservice.findAllDetails().forEach(list::add);
		return list;
	}
	@GetMapping("/getTicket/{emailId}")
	public Ticket getAllTicketByEmailId(@PathVariable("emailId") String emailId) {
		Ticket op = tservice.findTicketByemailId(emailId);
		
		
		return op;
		
	}

	@GetMapping("/ga/fullBookingDetails/{emailId}")
	public TicketStore getFullBookingDetails(@PathVariable("emailId") String emailId) {
		Booking b = resttemplate.getForObject("http://localhost:8041/bookingdetails/getAllBooking/{emailId}", Booking.class, emailId);
		Ticket t = resttemplate.getForObject("http://localhost:8041/ticket/getTicket/{emailId}", Ticket.class, emailId);
		TicketStore ts = new TicketStore(b.getId(), b.getTrain_name(), b.getTrain_no(), b.getFname(), b.getLname(),
				b.getAge(), b.getStart_from(), b.getDestination(), t.getCoach_no(), t.getSeat_no());
		return ts;
	}

}
