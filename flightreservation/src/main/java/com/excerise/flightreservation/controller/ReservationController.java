package com.excerise.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.excerise.flightreservation.dto.ReservationRequest;
import com.excerise.flightreservation.entities.Flight;
import com.excerise.flightreservation.entities.Reservation;
import com.excerise.flightreservation.service.FlightService;
import com.excerise.flightreservation.service.ReservationService;


@Controller
public class ReservationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	
	@Autowired
	private ReservationService service;
	@Autowired
	private FlightService flightService;
	
	// the ID is passed from the URL
	@RequestMapping("/showReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("showRegistrationPage():: start. flightId: {%d}", flightId);
		Flight flight = flightService.getFlightById(flightId);
		
		modelMap.addAttribute("flight", flight);
		return "reservation/completeReservation";
		
	}
	// create DTO class - data transfer object to hold all the page attributes
	@RequestMapping(value = "/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = service.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
		
		return "reservation/reservationConfirmation";
		
	}

}
