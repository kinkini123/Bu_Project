package com.securityimpl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securityimpl.models.Booking;
import com.securityimpl.models.Train;
import com.securityimpl.models.UserModel;
import com.securityimpl.services.AdminService;
import com.securityimpl.services.UserService;

@RequestMapping("/security")
@RestController
public class SecurityController {
	@Autowired
	private PasswordEncoder getPassWordEncoder;

	@Autowired
	UserService uservice;
	@Autowired
	AdminService aservice;

	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@RequestBody UserModel u) {
		try {
			String pass = getPassWordEncoder.encode(u.getPassword());
			u.setPassword(pass);
			System.out.println(u);
			UserModel um = uservice.createUser(u);
			return new ResponseEntity<Object>(um, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>("some problem occur", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/user/g")
	public List<UserModel> AllUserDetails() {
		List<UserModel> lt;
		try {
			lt = uservice.AllUserDetails();
			return lt;
		} catch (Exception e) {
			List<UserModel> l = null;
			System.out.println("no data");
			return l;
		}

	}

	@GetMapping("/user/getdbyid/{id}")
	public ResponseEntity<Object> UserDetailById(@PathVariable("id") int id) {
		try {
			UserModel um = uservice.UserDetailById(id);
			return new ResponseEntity<Object>(um, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>("no data is present", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/user/getTrainInfo")
	public List<Train> getTrainInformation() {
		List<Train> lt;
		try {
			lt = uservice.getTrainInfo();
			return lt;
		} catch (Exception e) {
			List<Train> l = null;
			System.out.println("no data");
			return l;
		}
	}

	@GetMapping("/user/getbyName/{username}")
	public ResponseEntity<Object> findByUsernameById(@PathVariable("username") String username) {
		try {
			System.out.println("hi..." + username);
			Optional<UserModel> op = uservice.findByUsername(username);
			System.out.println(op.get());
			
			if (op.isPresent()) {
				
					return new ResponseEntity<Object>(op.get(), HttpStatus.CREATED);

			} else {
				return new ResponseEntity<Object>("no value found", HttpStatus.NOT_FOUND);

			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("no data found", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/admin/g")
	public List<UserModel> AllAdminDetails() {
		List<UserModel> lt;
		try {
			lt =aservice.getAllAdminlDetails() ;
			return lt;
		} catch (Exception e) {
			List<UserModel> l = null;
			System.out.println("no data");
			return l;
		}

	}
	@PostMapping("/user/insertBooking")
	public ResponseEntity<Object> insertBookingInformation(@RequestBody Booking book) {
		try {
			Booking um = uservice.insertBookingInfo(book);
			return new ResponseEntity<Object>(um, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>("some error...", HttpStatus.NOT_FOUND);
		}
	}
}
