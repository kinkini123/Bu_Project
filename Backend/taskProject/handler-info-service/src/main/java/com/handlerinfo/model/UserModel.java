package com.handlerinfo.model;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class UserModel {
	@Id
	@Field
	private String id;
	@Field
	private String username;
	@Column(unique = true)
	private String emailId;
	@Field
	private String password;
	@Field
	private int age;
	@Field
	private String gender;
	@Field
	private long ph_no;
	@Field
	private String roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPh_no() {
		return ph_no;
	}

	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String id,String username, String emailId, String password, int age, String gender, long ph_no,
			String roles) {
		super();
		this.id=id;
		this.username = username;
		this.emailId = emailId;

		this.password = password;
		this.age = age;
		this.gender = gender;
		this.ph_no = ph_no;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", emailId=" + emailId + ", password=" + password
				+ ", age=" + age + ", gender=" + gender + ", ph_no=" + ph_no + ", roles=" + roles + "]";
	}

}