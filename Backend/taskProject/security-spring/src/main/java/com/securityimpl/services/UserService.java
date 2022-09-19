package com.securityimpl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.securityimpl.models.Booking;
import com.securityimpl.models.Train;
import com.securityimpl.models.UserModel;
@Service
public class UserService {
	public UserModel createUser(@RequestBody UserModel u) {
		RestTemplate r = new RestTemplate();
		return r.postForObject("http://localhost:8032/user/i", u, UserModel.class);
	}

	public UserModel UserDetailById(@PathVariable("id") int id) {
		RestTemplate r = new RestTemplate();
		return r.getForObject("http://localhost:8032/user/ga/{id}", UserModel.class, id);
	}

	public List<UserModel> AllUserDetails() {
		RestTemplate r = new RestTemplate();
		return r.getForObject("http://localhost:8032/user/g", List.class);
	}

	public List<Train> getTrainInfo() {
		RestTemplate r = new RestTemplate();
		return r.getForObject("http://localhost:8031/traindetails/g", List.class);
	}

	public Optional<UserModel> findByUsername(@PathVariable("username") String username) {
		RestTemplate r = new RestTemplate();

		Optional<UserModel> op = r.getForObject("http://localhost:8032/user/getAll/{username}", Optional.class,username);
		return op;
	}

	public Booking insertBookingInfo(@RequestBody Booking book) {
		RestTemplate r = new RestTemplate();

		Booking b = r.postForObject("http://localhost:8041/bookingdetails/i", book, Booking.class);
		return b;
	}

}
