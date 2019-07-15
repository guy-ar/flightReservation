package com.excerise.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excerise.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
