package com.securityimpl.models;

public class UserModel {

	private int id;

	private String username;

	private String password;

	private int age;

	private String roles;

	public UserModel() {

	}

	public UserModel(int id, String username, String password, int age, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", roles="
				+ roles + "]";
	}

}