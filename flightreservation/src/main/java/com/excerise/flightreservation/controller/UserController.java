package com.excerise.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.excerise.flightreservation.entities.User;
import com.excerise.flightreservation.service.SecurityService;
import com.excerise.flightreservation.service.UserService;



@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@Autowired
	private SecurityService securityService;
	
	// this bean is not automatically created = it will include definition in the WebSecurityConfig
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("showRegistrationPage():: start");
		return "login/registerUser";
	}
	
	@RequestMapping("/showLog")
	public String showLoginPage() {
		LOGGER.info("showLoginPage():: start");
		return "login/loginUser";
	}
	
	@RequestMapping(value = "registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("register():: saved user:{}", user);
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		service.saveUser(user);
		
		// move to login page after register is completed
		return "login/loginUser";
		
	}
	
	@RequestMapping(value = "loginUser", method=RequestMethod.POST)
	public String login(@RequestParam("user") String userEmail, @RequestParam("password") String password, ModelMap modelMap) {
		LOGGER.info("login():: start. userEmail: {}", userEmail);
		String msg = null;
		if (service.validateUser(userEmail, password)) {
			return "redirect:/showSearchFlight";
		} else {
			LOGGER.error("login:: failed as email and passwords are not valid");

			msg = "Email or password are incorrect, please try again";
			modelMap.addAttribute("msg", msg);
		}
		// move back to  login page after register failed
		return "login/loginUser";
		
	}
	//new function that will use the securityService in order to get the user details - instead the user repository
	/*@RequestMapping(value = "loginUser", method=RequestMethod.POST)
	public String login(@RequestParam("email") String userEmail, @RequestParam("password") String password, ModelMap modelMap) {
		LOGGER.info("login():: start. userEmail: {}", userEmail);
		String msg = null;
		boolean loginResponse = securityService.login(userEmail, password);
		if (loginResponse) {
			return "flight/findFlight";
		} else {
			LOGGER.error("login:: failed as email and passwords are not valid");

			msg = "Email or password are incorrect, please try again";
			modelMap.addAttribute("msg", msg);
		}
		// move back to  login page after register failed
		return "login/loginUser";
		
	}*/
	
	
	@RequestMapping("admin/showFlight")
	public String showAddFlight() {
		return "redirect:/admin/addFlight";
	}
	

	
}
