package com.excerise.flightreservation.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excerise.flightreservation.dto.ReservationRequest;
import com.excerise.flightreservation.entities.Flight;
import com.excerise.flightreservation.entities.Passenger;
import com.excerise.flightreservation.entities.Reservation;
import com.excerise.flightreservation.repos.ReservationRepository;
import com.excerise.flightreservation.util.EmailUtil;
import com.excerise.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.excerise.flightreservation.itinirary.suffix}")
	private String ITINIRARY_SUFFIX;

	@Value("${com.excerise.flightreservation.itinirary.dirpath}")
	private String ITINIRARY_DIR;


	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);


	@Autowired
	ReservationRepository repository;
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	PDFGenerator generator;
	
	@Override
	public Reservation saveReservation(Reservation reservation) {
		return repository.save(reservation);
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		return repository.save(reservation);
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		 repository.delete(reservation);

	}

	@Override
	public Reservation getReservationById(Long id) {
		LOGGER.info("getReservationById:: start, id: {}", id);
		Reservation reservation = null;
		Optional<Reservation> optionalReservation = repository.findById(id);
		if (optionalReservation.isPresent()) {
			reservation = optionalReservation.get();
		} else {
			reservation = new Reservation();
		}
		return reservation;
	}

	@Override
	public List<Reservation> getAllReservation() {
		return repository.findAll();
	}

	//in order to insure the the full funciotn will be handled in one transaction
	// need to add @Transactional annotation - that's it...
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("bookFlight:: start");
		// we will not handle the payment 
		// dummy create payment via payment gateway
		request.getCardNumber();
		// make payment...
			
		Long id = request.getFlightId();
		Flight flight = flightService.getFlightById(id);

		Passenger savedPassenger = passengerService.createPassengerFromReservationRequest(request);

		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		LOGGER.info("bookFlight:: saving reservation: {}", reservation);
		Reservation SavedReservation = repository.save(reservation);
		
		String filePath = ITINIRARY_DIR + SavedReservation.getId() + ITINIRARY_SUFFIX;
		generator.generateIninirary(SavedReservation, filePath);

		//emailUtil.sendEmail(SavedReservation.getPassenger().getEmail(), "Your reservation itinirary",
		//			"Please find attached itinirary", Optional.of(filePath));
			
		return SavedReservation;
	}
	
}
