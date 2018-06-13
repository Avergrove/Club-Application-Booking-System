package sg.nus.iss.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.iss.model.Booking;
import sg.nus.iss.model.User;
import sg.nus.iss.model.Userrole;
import sg.nus.iss.services.BookingService;
import sg.nus.iss.services.FacilityService;
import sg.nus.iss.services.UserService;
import sg.nus.iss.validators.UserValidator;

@Controller
public class UserController {

	@Autowired
	private BookingService bService;
	
	@Autowired
	private UserService uService;
	
	// Shows the registration page
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm(Model model) {
		return new ModelAndView("user-register");
	}
	
	// Check's user's submission, and register if valid.
	@RequestMapping(value = "/register-authentication", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user, BindingResult result) {

		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			
			mav.setViewName("redirect:/register");
			mav.addObject("errorMessage", result.getAllErrors());
			return mav;
		}
		
		try {
			// fill in the unfilled fields
			user.setJoindate(new Date());
			user.setExpirydate(new Date());
			user.setStatus("active");
			user.setRole(Userrole.MEMBER);
			uService.createUser(user);
			
			mav.setViewName("redirect:/login-authentication");
			mav.addObject("username", user.getUserid());
			mav.addObject("password", user.getPassword());
			
			return mav;			
			
		}
		
		catch(Exception ex){
			mav.setViewName("redirect:/register");
			mav.addObject("errorMessage", String.format("firstname - - is null lol", user.getFirstname()));
			
			return mav;
		}
		
		/*
		except()
		// Register the user. Server side security is theoretically speaking, not an issue for a class object
		
		User newUser = new User();
		newUser.setFirstname(firstname);
		newUser.setSecondname(secondname);
		newUser.setSurname(surname);
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(dob);
		System.out.println("\n\n\n\n\n\n\n\n\n");
		
		// Pay attention to the date
		try {
			newUser.setDob(new SimpleDateFormat("yyyy/MM/dd").parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newUser.setJoindate(new Date());
		newUser.setExpirydate(new Date());
		newUser.setEmail(email);
		newUser.setPhone(Integer.parseInt(phone));
		newUser.setStatus("active");
		newUser.setUserid(username);
		newUser.setPassword(password);
		newUser.setRole(Userrole.MEMBER);
		
		// UserValidator userValidator = new UserValidator();
		// userValidator.validate(userValidator, err);
		
		uService.createUser(newUser);
		
		
		ModelAndView mav = new ModelAndView("redirect:/login-authentication");
		mav.addObject("username", username);
		mav.addObject("password", password);
		
		return mav;
		*/
	}		
	
	
	
	// Shows the login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginForm(Model model) {
		
		return new ModelAndView("user-login");
	}	
	
	// Checks user's credentials, setup a session if login correctly, else, say invalid login.
	@RequestMapping(value = "/login-authentication", method = RequestMethod.POST)
	public ModelAndView authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password,  Model model, HttpServletRequest request) {
	
		User u = uService.authenticate(username, password);
		if(u == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			mav.addObject("valid", "Your password is invalid! orz");
			
			return mav;
		}
		
		else {
			request.getSession().setAttribute("user", u);
			return new ModelAndView("redirect:/");
		}
	}		
	
	// Invalidates (Logs out) the user
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Model model, HttpServletRequest request) {
		
		request.getSession().invalidate();
		ModelAndView mav = new ModelAndView("redirect:/");
		
		return mav;
	}
	
	
	// Lists all booking, and displays it on /Booking/viewHistory
	@RequestMapping(value = "/Booking/viewHistory", method = RequestMethod.GET)
	public ModelAndView viewHistory(@RequestParam("memberId") String memberId, Model model) {
		
		int mid = Integer.parseInt(memberId);
		ArrayList<Booking> bookings = bService.findBookingByMemberId(mid);
		model.addAttribute("bookings", bookings);
		
		return new ModelAndView("user-viewHistory");
	}
	
	
	
}
