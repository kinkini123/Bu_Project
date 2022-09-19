package com.traininfoservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traininfoservice.model.Train;
import com.traininfoservice.repository.TrainsRepository;

@Service
public class TrainService {
	@Autowired
	TrainsRepository trepo;

	public Optional<Train> findById(String train_no) {
		return trepo.findById(train_no);
	}

	public Train save(Train train) {
		train.setId(UUID.randomUUID().toString());
		Train t = trepo.save(train);
		return t;
	}

	public List<Train> findAllDetails() {
		return trepo.findAll();
	}

	public void deleteById(String train_no) {
		trepo.deleteById(train_no);
		
	}

	public Optional<Train> findByTrainId(String id) {
		// TODO Auto-generated method stub
		return trepo.findById(id);
	}

	public Train findByTrainName(String train_name) {
		// TODO Auto-generated method stub
		return trepo.findByTrainName(train_name);
	}

}
