package com.excerise.flightreservation.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.authentication.AuthenticationManager; 

// this annotation is used for Spring configuration and it refer to security infrastructure
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {//extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//UserDetailsService userDetailsService;

	
	//public void configurate(HttpSecurity http) throws Exception {
		// add all URI/URLs that can be accessed by all - not just by logged in user
		// then add the pattern that can be accessed only by admin
		// then all other requests should be authenticated - by anyRequest
		// disable the csrf - cross side reference support - as it is enable by default, but it requires more configuration
		//http.csrf().disable().
		//authorizeRequests().antMatchers("*/", "/*", "/showReg", "/", "/index.html", "/registerUser", "/loginUser", "/showLog", "/loginUser/*", "/registerUser/*").permitAll()
		//.antMatchers("admin/showAddFlight").hasAnyAuthority("ADMIN");
		
		//http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
	//}
	

	//@Bean
   // public BCryptPasswordEncoder passwordEncoder() {
   //     BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //    return bCryptPasswordEncoder;
   // }
	
	//@Override
	//@Bean
	//public AuthenticationManager authenticationManagerBean() throws Exception {
	//    return super.authenticationManagerBean();
	//}
	
	//@Override
	//@Bean
	//public UserDetailsService userDetailsService() {
	//    return new com.excerise.flightreservation.service.UserDetailsServiceImpl();
//	}
	
}
