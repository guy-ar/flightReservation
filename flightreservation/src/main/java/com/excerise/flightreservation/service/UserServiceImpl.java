package com.excerise.flightreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excerise.flightreservation.entities.User;
import com.excerise.flightreservation.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		repository.delete(user);

	}

	@Override
	public User getUserById(Long id) {
		//locate entity and return it
		Optional<User> userOption = repository.findById(id);
		if (userOption.isPresent()) {
			return userOption.get();
		} else {
			return new User();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	public Boolean validateUser(String userEmail, String password) {
		User user = repository.findByEmail(userEmail);
		if (user != null) {
			return user.getPassword().equals(password)?true:false;
		}
		return false;
		
	}

}
