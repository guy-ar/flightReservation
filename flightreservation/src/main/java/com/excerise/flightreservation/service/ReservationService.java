package com.excerise.flightreservation.service;

import java.util.List;

import com.excerise.flightreservation.dto.ReservationRequest;
import com.excerise.flightreservation.entities.Reservation;

public interface ReservationService {
	
	Reservation saveReservation(Reservation reservation);
	
	Reservation updateReservation(Reservation reservation);
	
	void  deleteReservation(Reservation reservation);
	
	Reservation getReservationById(Long id);
	
	List<Reservation> getAllReservation();
	
	Reservation bookFlight(ReservationRequest request);
	
}
