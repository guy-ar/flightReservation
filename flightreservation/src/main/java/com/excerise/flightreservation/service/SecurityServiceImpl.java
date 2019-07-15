package com.excerise.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	// we will use the UserDetailsServiceImpl implementation we created before
	// in order to retrieve the user from the DB
	//@Autowired
	//UserDetailsService userDetailsService;
	
	//@Autowired
	//AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String userName, String password) {
		/*UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		
		// need to create user name and password authentication token
		// we need to compare the password from DB and password from input after tokenized
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		
		// we will use spring authentication manager - it will store state of the authentication on the token 
		authenticationManager.authenticate(token);
		
		boolean result = token.isAuthenticated();
		// set the token to Spring security context
		if (result) {
			// based on this Spring will not prompt the login again and again
			// but it will hold it in Spring context
			SecurityContextHolder.getContext().setAuthentication(token);
			return true;
		}*/
		return false;
	}

}
