package com.securityimpl.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.securityimpl.models.UserModel;
import com.securityimpl.services.UserService;

public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService uservice;
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			System.out.println("hi"+username);
			Optional<UserModel> user= uservice.findByUsername(username);
			System.out.println("hello"+user.get());
			user.orElseThrow(()-> new UsernameNotFoundException("Not found"+username));
			return user.map(MyUserDetails::new).get();
			
		}

	}

