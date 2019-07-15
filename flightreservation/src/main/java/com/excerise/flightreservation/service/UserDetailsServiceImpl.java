package com.excerise.flightreservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.excerise.flightreservation.entities.User;
import com.excerise.flightreservation.repos.UserRepository;



@Service(value="UserDetailsService")
public class UserDetailsServiceImpl {//implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	UserRepository repository;
	

	// need to add also the handle for throwing UsernameNotFoundException
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// retrieve the user from DB
		LOGGER.info("loadUserByUsername():: start");
		
		User user = repository.findByEmail(username);
		if (user==null) {
			throw new UsernameNotFoundException("User not found for email: " + user);
		}
		
		// org.springframework.security.core.userdetails.User implements the userDetail interface
		// therefore we use it and return it
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				user.getRoles());
	}*/

}
