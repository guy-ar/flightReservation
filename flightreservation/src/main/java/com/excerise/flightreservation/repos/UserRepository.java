package com.excerise.flightreservation.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.excerise.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
		// no need to set the @query annotation, if using the naming convention
		// of findBy<Property> Spring will know how to generate the query
		public User findByEmail(String email);

}
