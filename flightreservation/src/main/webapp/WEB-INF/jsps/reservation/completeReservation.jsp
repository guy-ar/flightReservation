<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<!--  we can use jstl after adding it to the POM in order to manipulate the data from location list 
for this we added the taglib above-->
<head>
<meta charset="windows-1255">
<title>Display Flights</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link rel="stylesheet" href="../../../styles/main.css">

</head>
<body>
<div class="content container">
<br>
    <h1>Complete Reservation</h1>
     ${msg}
    <br>

     <!-- we will use JSP to get the list length and control the flows -->
    
        <div class="list-group"> 
            <div class="card">
  				<div class="card-body">
	                <div class="d-flex w-100 justify-content-between">
	                    <h5 class="mb-1"> ${flight.operatingAirlines}
	                    Flight Number: ${flight.flightNumber}
	                    </h5>
	                    <small>Flight ID:  ${flight.id}</small>
	                </div>
	                <div class="d-flex w-100 justify-content-between">
		                <p class="mb-1">
	                        Flight Origin: <Strong>${flight.departureCity} </Strong>
	                    </p>
	                    <p class="mb-1">
	                        Flight Destination: <Strong>${flight.arrivalCity} </Strong>
	                    </p>
	                    <p class="mb-1">
		                	Arrival Time: ${flight.estimatedDepartureTime}
		                </p>
	                </div>
	                
	            </div>
	        </div>
        </div>
        <br>
        <div class="content container">
			<h4>Passenger details</h4>
	
			<form id="reservation-form" action="completeReservation" method="post" class ="form-size">
		        <div class="form-group">
		            <label for="passengerFirstName">Passenger First Name</label>
		            <input type="text" class="form-control" id="passengerFirstName" name="passengerFirstName" placeholder="Enter user passenger first name">
		        </div>
		        <div class="form-group">
		            <label for="passengerLastName">Passenger Last Name</label>
		            <input type="text" class="form-control" id="passengerLastName" name="passengerLastName" placeholder="Enter Passenger last name">
		        </div>
		        <div class="form-group">
		            <label for="passengerEmail">Passenger Email address</label>
		            <input type="email" class="form-control" id="passengerEmail" name="passengerEmail" placeholder="Enter passenger email">
		        </div>
		        <div class="form-group">
		            <label for="passengerPhone">Phone</label>
		            <input type="text" class="form-control" id="passengerPhone" name="passengerPhone" placeholder="55-8887-898">
		        </div>
		        <input type="hidden" name="flightId" value="${flight.id}"/>
		    
			    <br>
			    <h4>Payment details</h4>
	
		        <div class="form-group">
		            <label for="nameOnCard">Name on Card</label>
		            <input type="text" class="form-control" id="nameOnCard" name="nameOnCard" placeholder="Enter credit card holder name">
		        </div>
		        <div class="form-group">
		            <label for="cardNumber">Credit Card Number</label>
		            <input type="text" class="form-control" id="cardNumber" name="cardNumber" placeholder="Enter credti card number">
		        </div>
		        <div class="form-group">
		            <label for="expirationDate">Credit Card Expiration</label>
		            <input type="text" class="form-control" id="expirationDate" name="expirationDate" placeholder="Enter expiration date">
		        </div>
		        <div class="form-group">
		            <label for="securotyCode">Credti Card CVV</label>
		            <input type="text" class="form-control" id="securotyCode" name="securotyCode" placeholder="587">
		        </div>
		        
		        <button type="submit" class="btn btn-primary">Save</button>
		    </form>
    
		</div>	
    
    
   
</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>

</html>