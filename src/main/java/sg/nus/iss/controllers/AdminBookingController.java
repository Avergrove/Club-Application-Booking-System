package sg.nus.iss.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.iss.model.Booking;
import sg.nus.iss.services.BookingService;
import sg.nus.iss.services.BookingServiceImpl;

@RequestMapping(value = "/Admin/Booking")
@Controller
public class AdminBookingController {

	@Autowired
	private BookingService bs;
	
	
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
	
	// Displays the edit page
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showDetail(@RequestParam("bookingId") String bookingId, Model model)
	{
		int bid = Integer.parseInt(bookingId);
		
		Booking b = bs.findBookingByBookingId(bid);
		model.addAttribute("booking", b);
		
		return "booking-edit";
	 }	

	// Un-Cancels the booking (sets active to cancelled)
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String uncancelBooking(@RequestParam("bookingId") String bookingId, Model model)
	{
		int bid = Integer.parseInt(bookingId);
		
		Booking b = bs.findBookingByBookingId(bid);
		
		model.addAttribute("bookingId", bookingId);
		model.addAttribute("comments", b.getComments());
		model.addAttribute("bookstatus", "confirmed");
		
		return "redirect:/Admin/Booking/submit";
	 }	
	
	// Cancels the booking (sets active to cancelled)
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancelBooking(@RequestParam("bookingId") String bookingId, Model model)
	{
		int bid = Integer.parseInt(bookingId);
		
		Booking b = bs.findBookingByBookingId(bid);
		
		model.addAttribute("bookingId", bookingId);
		model.addAttribute("comments", b.getComments());
		model.addAttribute("bookstatus", "cancelled");
		
		return "redirect:/Admin/Booking/submit";
	 }
	
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String saveEditGet(@RequestParam("bookingId") String bookingId, @RequestParam("comments") String comments, @RequestParam("bookstatus") String bookstatus, Model model)
	{
		
		int bid = Integer.parseInt(bookingId);
		Booking b = bs.findBookingByBookingId(bid);
		
		b.setComments(comments);
		b.setBookstatus(bookstatus);
		bs.updateBooking(b);
		
		 ArrayList<Booking> bookings = bs.findAllBooking();
		 model.addAttribute("Booklist", bookings);
		 return "redirect:/Admin/Booking/list";
	 }		
	
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveEdit(@RequestParam("bookingId") String bookingId, @RequestParam("comments") String comments, @RequestParam("bookstatus") String bookstatus, Model model)
	{
		
		int bid = Integer.parseInt(bookingId);
		Booking b = bs.findBookingByBookingId(bid);
		
		if(comments == null) {
			b.setComments("");
		}
		
		else {
			b.setComments(comments);
		}
		b.setBookstatus(bookstatus);
		bs.updateBooking(b);
		
		 ArrayList<Booking> bookings = bs.findAllBooking();
		 model.addAttribute("Booklist", bookings);
		 return "redirect:/Admin/Booking/list";
	 }	
	
	
	
}
