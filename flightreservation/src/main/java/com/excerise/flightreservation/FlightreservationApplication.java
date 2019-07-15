package com.excerise.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightreservationApplication extends SpringBootServletInitializer {
	
	// in order to support war need to extends SpringBootServletInitializer
	// and add one more method to give the source class (current) 
	// that will serve as root for the application
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FlightreservationApplication.class);
	}
	// test git
	
	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

}
