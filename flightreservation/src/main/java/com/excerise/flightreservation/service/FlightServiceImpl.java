package com.excerise.flightreservation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excerise.flightreservation.entities.Flight;
import com.excerise.flightreservation.repos.FlightReposiroty;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightReposiroty repository;
	
	@Override
	public List<Flight> searchflight(String departureCity, String arrivalCity, Date dateOfDeparture) {
		return repository.findFlightsByOrignDestinationsAndDate(departureCity, arrivalCity, dateOfDeparture);
	}

	@Override
	public Flight saveFlight(Flight flight) {
		return repository.save(flight);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		return repository.save(flight);
	}

	@Override
	public void deleteFlight(Flight flight) {
		repository.delete(flight);

	}

	@Override
	public Flight getFlightById(Long id) {
		Flight flight = null;
		Optional<Flight> optionalFlight = repository.findById(id);
		if (optionalFlight.isPresent()) {
			flight = optionalFlight.get();
		} else {
			flight = new Flight();
		}
		return flight;
	}

	@Override
	public List<Flight> getAllFlights() {
		return repository.findAll();
	}

}
