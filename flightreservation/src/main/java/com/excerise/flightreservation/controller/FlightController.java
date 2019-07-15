package com.excerise.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.excerise.flightreservation.entities.Flight;
import com.excerise.flightreservation.service.FlightService;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	
	@Autowired
	FlightService service;
	
	@RequestMapping("/showSearchFlight")	
	public ModelAndView showFindFlightPage() {
		LOGGER.info("showFindFlightPage():: start");
		return new ModelAndView("flight/findFlight");
		
		
		/*public ModelAndView loginValidate(HttpServletRequest req, RedirectAttributes redir){
			...

			    modelAndView.setViewName("redirect:welcome");
			    redir.addFlashAttribute("USERNAME",uname);
			    return modelAndView;*/
	}
	
	@RequestMapping("/displayFlights")	
	public String showDisplayFlightsPage() {
		LOGGER.info("showDisplayFlightsPage():: start");
		
		return "flight/displayFlights";
	}
	
	// since we have String that represent Date - we will use DateTimeFormat with patteren of specific date format
	@RequestMapping(value = "findFlight", method=RequestMethod.POST)
	public ModelAndView showRegistrationPage(@RequestParam("departureCity") String departureCity, @RequestParam("arrivalCity") String arrivalCity,
			@RequestParam("dateOfDeparture") @DateTimeFormat(pattern="MM-dd-yyyy") Date dateOfDeparture, RedirectAttributes redir) {
			//@RequestParam("dateOfDeparture") @DateTimeFormat(pattern="MM-dd-yyyy") Date dateOfDeparture, ModelMap modelMap) {
		
		List<Flight> flightList = service.searchflight(departureCity, arrivalCity, dateOfDeparture);
			
		//modelMap.addAttribute("flightList", flightList);
		//LOGGER.info("ModelMap: " + modelMap.values());
		redir.addFlashAttribute("flightList", flightList);
		// move to show all flights that match the search criteria
		return new ModelAndView("redirect:/displayFlights");
	}

}
