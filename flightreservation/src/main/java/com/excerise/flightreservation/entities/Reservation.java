package com.excerise.flightreservation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="reservation")
public class Reservation extends AbstractEntity {
	
	@Column(name="checked_in")
	private Boolean checkedIn;
	
	@Column(name="number_of_bags")
	private int numberOfBags;
	
	// add relation annotation to fields
	@OneToOne
	private Passenger passenger; 
	
	@OneToOne
	private Flight flight;
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
