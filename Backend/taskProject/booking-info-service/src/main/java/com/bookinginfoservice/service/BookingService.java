package com.bookinginfoservice.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinginfoservice.model.Booking;
import com.bookinginfoservice.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository brepo;

	public Optional<Booking> findById(String id) {
		// TODO Auto-generated method stub
		return brepo.findById(id);
	}

	public Booking save(Booking book) {
		// TODO Auto-generated method stub
		Booking b = brepo.save(book);
		return b;
	}

	public List<Booking> findAllDetails() {
		// TODO Auto-generated method stub
		return brepo.findAll();
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		brepo.deleteById(id);
	}

	public Booking findByemailId(String emailId) {
		// TODO Auto-generated method stub
		return brepo.findByemailId(emailId);
	}

}