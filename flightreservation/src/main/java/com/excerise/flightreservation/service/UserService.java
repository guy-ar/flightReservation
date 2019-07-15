package com.excerise.flightreservation.service;

import java.util.List;

import com.excerise.flightreservation.entities.User;


public interface UserService {
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void  deleteUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
	Boolean validateUser(String userEmail, String password);
}
