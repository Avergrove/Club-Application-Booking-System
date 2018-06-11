package sg.nus.iss.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.iss.model.Booking;
import sg.nus.iss.services.BookingServiceImpl;

@RequestMapping(value = "/Admin/Booking")
@Controller
public class AdminBookingController {

	@Autowired
	private BookingServiceImpl bs;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
	{
	 ModelAndView mav = new ModelAndView("booking-list");
	 ArrayList<Booking> url = bs.findAllBooking();
	 for (Booking s: url)
	 {
		 	System.out.println(s.toString());
	 }
	 mav.addObject("Booklist",url);
	 return mav;
	 }
	
	
}
