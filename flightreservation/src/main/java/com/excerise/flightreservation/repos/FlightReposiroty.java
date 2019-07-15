package com.excerise.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.excerise.flightreservation.entities.Flight;

public interface FlightReposiroty extends JpaRepository<Flight, Long> {
	
	// this @query annotation will include the jpql query - it is not native SQL but our objects
	// we are adding parameters that start with column and the @Param annotation will do the mapping between the variable names 
	// of the function and the parameter values that will be sent to Hibernate
	@Query("from Flight where departureCity=:departureCityIn and arrivalCity=:arrivalCityIn and dateOfDeparture=:dateOfDepartureIn")
	public List<Flight> findFlightsByOrignDestinationsAndDate(@Param("departureCityIn") String departureCity, @Param("arrivalCityIn") 
	String arrivalCity, @Param("dateOfDepartureIn") Date dateOfDeparture);
	
	@Query("from Flight where departureCity=:departureCityIn")
	public List<Flight> findFlightsByOrign(@Param("departureCityIn") String departureCity);
	
	@Query("from Flight where arrivalCity=:arrivalCityIn")
	public List<Flight> findFlightsByDestinations(@Param("arrivalCityIn") String arrivalCity);
	
	@Query("from Flight where dateOfDeparture=:dateOfDepartureIn")
	public List<Flight> findFlightsByDate(@Param("dateOfDepartureIn") Date dateOfDeparture);
	
	@Query("from Flight where departureCity=:departureCityIn and arrivalCity=:arrivalCityIn")
	public List<Flight> findFlightsByOrignDestinations(@Param("departureCityIn") String departureCity, @Param("arrivalCityIn") 
	String arrivalCity);
	
	@Query("from Flight where departureCity=:departureCityIn and dateOfDeparture=:dateOfDepartureIn")
	public List<Flight> findFlightsByOrignAndDate(@Param("departureCityIn") String departureCity, @Param("dateOfDepartureIn") Date dateOfDeparture);
	
	@Query("from Flight where arrivalCity=:arrivalCityIn and dateOfDeparture=:dateOfDepartureIn")
	public List<Flight> findFlightsByDestinationAndDate(@Param("arrivalCityIn")	String arrivalCity, @Param("dateOfDepartureIn") Date dateOfDeparture);

}
