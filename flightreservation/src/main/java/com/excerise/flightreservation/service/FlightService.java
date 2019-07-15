package com.excerise.flightreservation.service;

import java.util.Date;
import java.util.List;

import com.excerise.flightreservation.entities.Flight;


public interface FlightService {
	
	List<Flight> searchflight(String departureCity, String arrivalCity, Date dateOfDeparture);
	
	Flight saveFlight(Flight flight);
	
	Flight updateFlight(Flight flight);
	
	void  deleteFlight(Flight flight);
	
	Flight getFlightById(Long id);
	
	List<Flight> getAllFlights();

}
