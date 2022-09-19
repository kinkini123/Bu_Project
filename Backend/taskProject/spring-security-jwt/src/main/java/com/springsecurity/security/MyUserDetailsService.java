package com.springsecurity.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.controller.SecurityController;
import com.springsecurity.models.UserModel;


@Service

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private SecurityController repo;
	static String user,  password;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel usermodel=repo.findByUserName(username);
		 if (usermodel == null) {
	            throw new UsernameNotFoundException("Could not find user"+" "+usermodel);
	        }
		 System.out.println("helloooo......"+username);
			
		return new MyUserDetails(usermodel);
		
		
		
	}

}
