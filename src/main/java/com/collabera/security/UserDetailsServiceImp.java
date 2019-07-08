package com.collabera.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.collabera.models.Users;
import com.collabera.services.UserService;

public class UserDetailsServiceImp implements UserDetailsService{
	@Autowired
	UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user = service.getUserByName(username);
				
		UserBuilder builder = null;
		
		if(user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
			builder.roles("Admin");
		}
		else
			throw new UsernameNotFoundException("User not found");
		return builder.build();
		
	}

}
