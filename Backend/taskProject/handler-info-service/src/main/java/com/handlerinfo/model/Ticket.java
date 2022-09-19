package com.handlerinfo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ticket")

public class Ticket {
	@Id

	private int id;
	@Field
	private String coach_no;
	@Field
	private int seat_no;
	
	public Ticket() {
		super();
	}

	public Ticket(int id, String coach_no, int seat_no) {
		super();
		this.id = id;
		this.coach_no = coach_no;
		this.seat_no = seat_no;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoach_no() {
		return coach_no;
	}

	public void setCoach_no(String coach_no) {
		this.coach_no = coach_no;
	}

	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}


	

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", coach_no=" + coach_no + ", seat_no=" + seat_no + "]";
	}

	
}