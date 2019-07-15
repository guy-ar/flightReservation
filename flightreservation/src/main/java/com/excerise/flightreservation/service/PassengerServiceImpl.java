package com.excerise.flightreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excerise.flightreservation.dto.ReservationRequest;
import com.excerise.flightreservation.entities.Passenger;
import com.excerise.flightreservation.repos.PassengerRepositry;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerRepositry repository;
	
	@Override
	public Passenger savePassenger(Passenger passenger) {
		return repository.save(passenger);
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		return repository.save(passenger);
	}

	@Override
	public void deletePassenger(Passenger passenger) {
		repository.delete(passenger);

	}

	@Override
	public Passenger getPassengerById(Long id) {
		Passenger passenger = null;
		Optional<Passenger> optionalPassenger = repository.findById(id);
		if (optionalPassenger.isPresent()) {
			passenger = optionalPassenger.get();
		} else {
			passenger = new Passenger();
		}
		
		return passenger;
	}

	@Override
	public List<Passenger> getAllPassenger() {
		return repository.findAll();
	}

	@Override
	// map the fields from the request and create new entity in the DB
	public Passenger createPassengerFromReservationRequest(ReservationRequest request) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = repository.save(passenger);
		return savedPassenger;

	}

}
