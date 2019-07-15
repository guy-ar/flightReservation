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
    <h1>Flight List</h1>
     ${msg}
    <br>

     <!-- we will use JSP to get the list length and control the flows -->
    
        <div class="list-group">

            <c:forEach items="${flightList}" var="flight"> 
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
		                <p class="mb-1">
		                	<a href="showReservation?flightId=${flight.id}" class="btn btn-warning">Create Reservation</a>
	                    </p>
	                </div>
	                
	            </div>
	        </div>
            </c:forEach>
                
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