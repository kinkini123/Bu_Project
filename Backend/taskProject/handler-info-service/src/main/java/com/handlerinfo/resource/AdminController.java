package com.handlerinfo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.handlerinfo.model.Booking;
import com.handlerinfo.model.Ticket;
import com.handlerinfo.model.TicketStore;
import com.handlerinfo.model.Train;
import com.handlerinfo.model.UserModel;
import com.handlerinfo.service.AdminServices;


@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private AdminServices adminservice;
	
	@Autowired
	private RestTemplate restt;
	
//	@PostMapping("/{i}")
//	public UserModel insertUserModel(@RequestBody UserModel admin) {
//
//		Optional<UserModel> op = adminservice.findById(admin.getId());
//		if (op.isPresent()) {
//			return admin;
//		} else {
//			System.out.println("Data saved !!");
//			admin.setRoles("ROLES_ADMIN");
//			UserModel u = adminservice.save(admin);
//
//			System.out.println(u);
//			return u;
//		}
//	}
	@GetMapping("/getAll/{emailId}")
	public UserModel getAllUserDetailByEmailId(@PathVariable("emailId") String emailId) {
		UserModel op = adminservice.findByemailId(emailId);
		
		
		return op;
		
	}
	@GetMapping("/g")
	public List<UserModel> getAllUserModelDetails(){
		List<UserModel> list = new ArrayList();
		adminservice.findAllDetails().forEach(list::add);
		return list;	
	}
	@PostMapping("/p/t")
	public Train insertTrainInfo(@RequestBody Train train) {

		Train t1 = restt.postForObject("http://localhost:8031/traindetails/i", train, Train.class);
		return t1;
	}
//	@GetMapping("/b")
//	public List<Booking> getBookingInfo() {
//		 List<Booking> book=
//				 webClientBuilder.build().get().uri("http://localhost:8041/bookingdetails/g")
//				 .retrieve().bodyToMono(List.class).block();
////		List<Train> train = resttemplate.getForObject("http://localhost:8031/traindetails/g", List.class);
//		 		return book;
//
//	}
	@PostMapping("/p/ticket")
	public Ticket insertTicketInfo(@RequestBody Ticket ticket) {

		Ticket t1 = restt.postForObject("http://localhost:8041/ticket/i", ticket, Ticket.class);
		return t1;
	}
	@GetMapping("/ga/viewticket/{id}")
	public TicketStore getFullBookingDetails(@PathVariable("id") int id) {
		TicketStore ts = restt.getForObject("http://localhost:8041/ticket/ga/fullBookingDetails/{id}",
				TicketStore.class, id);

		return ts;
	}
	@GetMapping("/t")
	public List<Booking> getAllBookingInfo() {
		List<Booking> book = restt.getForObject("http://localhost:8041/bookingdetails/g",List.class);
				
		return book;

	}
}
