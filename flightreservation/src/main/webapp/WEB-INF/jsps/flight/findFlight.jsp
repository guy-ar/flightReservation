<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="windows-1255">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link rel="stylesheet" href="../../../../styles/main.css">

	<title>Find Flight</title>
</head>
<body>

	<div class="content container">
		<h1>Find Flight</h1>
	<!--  in case error during login - present the error message -->
	${msg}
	<form id="flight-form" action="findFlight" method="post" class ="form-size">
        <div class="form-group">
            <label for="departureCity">From</label>
            <input type="text" class="form-control" id="departureCity" name="departureCity" aria-describedby="departureCity" placeholder="DAL">
            <small id="departureCityHelp" class="form-text text-muted">Enter the origin city.</small>
        </div>
        <div class="form-group">
            <label for="arrivalCity">To</label>
            <input type="text" class="form-control" id="arrivalCity" name="arrivalCity" aria-describedby=arrivalCity" placeholder="AUS">
            <small id="departureCityHelp" class="form-text text-muted">Enter the destination city.</small>
        </div>
        <div class="form-group">
            <label for="dateOfDeparture">Date</label>
            <input type="text" class="form-control" id="dateOfDeparture" name="dateOfDeparture" aria-describedby="dateOfDepartureHelp" placeholder="mm-dd-YYYY">
            <small id="dateOfDepartureHelp" class="form-text text-muted">Enter the desired date for flight.</small>
        </div>
        
        <button type="submit" class="btn btn-primary">Find Flight</button>
    </form>
    
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