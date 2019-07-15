package com.excerise.flightreservation.service;

import java.util.List;

import com.excerise.flightreservation.dto.ReservationRequest;
import com.excerise.flightreservation.entities.Passenger;

public interface PassengerService {
	Passenger savePassenger(Passenger passenger);
	
	Passenger updatePassenger(Passenger passenger);
	
	void  deletePassenger(Passenger passenger);
	
	Passenger getPassengerById(Long id);
	
	List<Passenger> getAllPassenger();
	
	Passenger createPassengerFromReservationRequest(ReservationRequest request);
}
