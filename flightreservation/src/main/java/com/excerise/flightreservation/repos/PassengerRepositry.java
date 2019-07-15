package com.excerise.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excerise.flightreservation.entities.Passenger;

public interface PassengerRepositry extends JpaRepository<Passenger, Long> {

}
