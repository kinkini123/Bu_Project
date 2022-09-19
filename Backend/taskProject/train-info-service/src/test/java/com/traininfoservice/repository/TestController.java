package com.traininfoservice.repository;

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

import com.traininfoservice.model.Train;
import com.traininfoservice.resource.TrainController;
import com.traininfoservice.service.TrainService;

@SpringBootTest
public class TestController {
	@MockBean
	private TrainsRepository trepo;
	@Autowired
	private TrainService tservice;

//	@Test
//	public void insertTrainTest() {
//		Train train = new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0);
//		// trepo.save(train);
//
//		// ResponseEntity<Object> actualResult = tcon.getAllTrainDetailById("5");
//		// assertNotNull(actualResult);
//		// when(trepo.findById("7")).thenReturn(Optional.of(train));
//		when(trepo.save(train)).thenReturn(train);
//		assertEquals(train, tcon.insertTrain(train));
//
//	}
//
//	@Test
//	public void getAllTrainsTest() {
//		when(trepo.findAll())
//				.thenReturn(Stream
//						.of(new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0),
//								new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0))
//						.collect(Collectors.toList()));
//		assertEquals(2, tcon.getAllTrainDetails().size());
//	}

//	@Test
//	public void getDetailsByTno() {
//		String no = "7";
////
////		Train train = new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0);
////		trepo.save(train);
//		when(trepo.findById(no))
//				.thenReturn(Optional.of(new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0)));
//		assertEquals(1, Optional.of(tcon.getAllTrainDetailById(no)));
//
//	}
//
//	@Test
//	public void DeleteTrainDeails() {
//		Train train = new Train("7", "bibhuti", "kolkata", null, "delhi", null, 800.0);
//		trepo.delete(train);;
//		assertEquals(0, tcon.deleteTrainDetailsById("7"));
//	}
	@Test
	public void insertTrainTest() {
		Train train = new Train("1","7", "bibhuti", "kolkata", null, "delhi", null, 800.0);
		when(trepo.save(train)).thenReturn(train);
		assertEquals(train, tservice.save(train));

	}
	@Test
	public void getAllTrainsTest() {
		when(trepo.findAll())
				.thenReturn(Stream
						.of(new Train("1","7", "bibhuti", "kolkata", null, "delhi", null, 800.0),
								new Train("1","7", "bibhuti", "kolkata", null, "delhi", null, 800.0))
						.collect(Collectors.toList()));
		assertEquals(2, (tservice.findAllDetails()).size());
	}
	@Test
	public void deleteById() {
		Train tr = new Train("1","7", "bibhuti", "kolkata", null, "delhi", null, 800.0);
		tservice.deleteById("7");
		verify(trepo).deleteById(any());
		
	}
}
