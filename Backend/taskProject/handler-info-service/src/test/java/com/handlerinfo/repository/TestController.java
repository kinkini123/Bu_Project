package com.handlerinfo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.handlerinfo.model.UserModel;
import com.handlerinfo.service.UserServices;



@SpringBootTest
public class TestController {

	@MockBean
	private UserRepository trepo;
	@Autowired
	private UserServices uservice;

	@Test
	public void insertUserTest() {
		UserModel user = new UserModel("2","tua","bhusan","j",55,"ab", 0, "abc");
		// trepo.save(train);

		// ResponseEntity<Object> actualResult = tcon.getAllTrainDetailById("5");
		// assertNotNull(actualResult);
		// when(trepo.findById("7")).thenReturn(Optional.of(train));
		when(trepo.save(user)).thenReturn(user);
		assertEquals(user, uservice.save(user));

	}

	@Test
	public void getAllUserTest() {
		when(trepo.findAll())
				.thenReturn(Stream
						.of(new UserModel("2","tua","bhusan","j",55,"ab", 0, "abc"),
								new UserModel("2","tua","bhusan","j",55,"ab", 0, "abc"))
						.collect(Collectors.toList()));
		assertEquals(2, (uservice.findAllDetails().size()));
	}

//	@Test
//	public void getByIdTest() {
//		Optional train = Optional
//		.of(new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0));
//		//String train_no="124";
//		trepo.save(train);
//		when(trepo.findById(train_no)).thenReturn(Optional
//						.of(new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0)));
//		assertEquals(1,Optional.of(uservice.findById(train_no)));
//	}

	@Test
	public void deleteById() {
		UserModel u = new UserModel("2","tua","bhusan","j",55,"ab", 0, "abc");
		uservice.deleteById("2");
		verify(trepo).deleteById(any());

	}

}