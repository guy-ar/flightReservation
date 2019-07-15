package com.excerise.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excerise.flightreservation.dto.UpdateReservationRequest;
import com.excerise.flightreservation.entities.Reservation;
import com.excerise.flightreservation.repos.ReservationRepository;
import com.excerise.flightreservation.service.ReservationService;



@RestController
@RequestMapping("/reservations")
public class ReservationRestController {
	
	@Autowired
	ReservationRepository repository;
	
	@Autowired
	ReservationService service;
	
	
	//the find method will include path URI parameter
	// in addition @PathVariable is used to link the parameter from the uri to the variable
	@GetMapping("/{id}")
	public Reservation findReservation(@PathVariable Long id) {
		return service.getReservationById(id);
	}
	
	// @PutMapping indicate that it will update as PUT HTTP request,
	// also @RequestBody indicate that input will be converted by spring to 
	// Json and will be part of body context
	//@RequestMapping("/reservation")
	//public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
	@PutMapping
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		Reservation reservation = service.getReservationById(request.getId());
		
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return repository.save(reservation);
	}

}
