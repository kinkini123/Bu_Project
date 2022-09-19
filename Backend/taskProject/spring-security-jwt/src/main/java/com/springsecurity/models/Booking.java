package com.springsecurity.models;



public class Booking {

	private String id;
	
	private String train_name;
	
	private String train_no;
	
	private String fname;
	
	private String lname;
	
	private int age;
	
	private String start_from;
	
	private String destination;
	private String emailId;
	private String coach_no;

	private int seat_no;
	public Booking() {
		super();
	}

	
	public Booking(String id, String train_name, String train_no, String fname, String lname, int age,
			String start_from, String destination, String emailId, String coach_no, int seat_no) {
		super();
		this.id = id;
		this.train_name = train_name;
		this.train_no = train_no;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.start_from = start_from;
		this.destination = destination;
		this.emailId = emailId;
		this.coach_no = coach_no;
		this.seat_no = seat_no;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getTrain_no() {
		return train_no;
	}

	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStart_from() {
		return start_from;
	}

	public void setStart_from(String start_from) {
		this.start_from = start_from;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "Booking [id=" + id + ", train_name=" + train_name + ", train_no=" + train_no + ", fname=" + fname
				+ ", lname=" + lname + ", age=" + age + ", start_from=" + start_from + ", destination=" + destination
				+ ", emailId=" + emailId + ", coach_no=" + coach_no + ", seat_no=" + seat_no + "]";
	}

	
	
}