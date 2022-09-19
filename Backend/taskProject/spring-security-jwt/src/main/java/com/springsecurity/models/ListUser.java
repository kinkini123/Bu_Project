package com.springsecurity.models;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
	private List<UserModel> user;

	public ListUser() {
		
		super();
	}

	public List<UserModel> getUser() {
		return user;
	}

	public void setUser(List<UserModel> user) {
		this.user = user;
	}

	public ListUser(List<UserModel> user) {
		super();
		this.user = user;
	}
	
}
