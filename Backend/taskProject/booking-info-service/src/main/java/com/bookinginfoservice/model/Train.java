package com.bookinginfoservice.model;

import java.time.LocalTime;

import org.springframework.data.annotation.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document

public class Train {
	@Id
	private String train_no;
	@Field
	private String train_name;
	@Field
	private String start_from;
	@Field
	private String departure_time;
	@Field
	private String to_destination;
	@Field
	private String arrival_time;
	@Field
	private double price;

	public Train() {
		super();
	}

	public Train(String train_no, String train_name, String start_from, String departure_time, String to_destination,
			String arrival_time, double price) {
		super();
		this.train_no = train_no;
		this.train_name = train_name;
		this.start_from = start_from;
		this.departure_time = departure_time;
		this.to_destination = to_destination;
		this.arrival_time = arrival_time;
		this.price = price;
	}

	public String getTrain_no() {
		return train_no;
	}

	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getStart_from() {
		return start_from;
	}

	public void setStart_from(String start_from) {
		this.start_from = start_from;
	}


	public String getTo_destination() {
		return to_destination;
	}

	public void setTo_destination(String to_destination) {
		this.to_destination = to_destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	@Override
	public String toString() {
		return "Train [train_no=" + train_no + ", train_name=" + train_name + ", start_from=" + start_from
				+ ", departure_time=" + departure_time + ", to_destination=" + to_destination + ", arrival_time="
				+ arrival_time + ", price=" + price + "]";
	}

	
}