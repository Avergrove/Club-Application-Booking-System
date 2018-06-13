package sg.nus.iss.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.nus.iss.model.Booking;
import sg.nus.iss.model.Category;
import sg.nus.iss.model.Facility;
import sg.nus.iss.services.BookingService;
import sg.nus.iss.services.CategoryService;
import sg.nus.iss.services.FacilityService;

@RequestMapping(value="/Booking")
@Controller
public class UserBookingController {
	
	@Autowired
	private BookingService bService;
	
	@Autowired
	private FacilityService fService;
	
	@Autowired
	private CategoryService cService;
	
	//@Autowired
	//private BookingValidator bValidator;
	
	@InitBinder("booking")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		//binder.addValidators(bValidator);

	}

	
	@RequestMapping(value="/history")
	public ModelAndView userBookingHistory(HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("user");
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			mav = new ModelAndView("/member-course-history");
			mav.addObject("bhistory", bService.findBookingByMID(us.getUser().getMemberid()));
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newBookingPage() {
		ModelAndView mav = new ModelAndView("booking-new");
		mav.addObject("booking", new Booking());
		Map<Integer, String> facilities = new LinkedHashMap<Integer,String>();
		for (Facility f: fService.findAllFacility()) {
			facilities.put(f.getFacilityId(),f.getFacilityname());
		}
		Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
		for (Category c: cService.findAllCategory()) {
			categories.put(c.getCategoryId(),c.getCategoryname());
		}
		Map<Integer, Date> dates = new LinkedHashMap<Integer,Date>();
		for (Booking b: bService.findCurrentFutureBookings()) {
			dates.put(b.getFacilityId(), b.getStartdate());
		}
		
		mav.addObject("categorylist",categories);
		mav.addObject("facilitylist",facilities);
		mav.addObject("bookingdates",dates);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute @Valid Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) throws ParseException {

		if (result.hasErrors())
			return new ModelAndView("booking-new");

		ModelAndView mav = new ModelAndView();
		String message = "New booking " + booking.getBookingId() + " was successfully created.";
		UserSession us = (UserSession) session.getAttribute("user");
		booking.setUsr(us.getUser());
		booking.setBookstatus(booking.CONFIRMED);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		String dd = df.format(calobj.getTime());	
		Date ddd= (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		booking.setBookingdate(ddd);
		bService.CreateBooking(booking);
		mav.setViewName("redirect:/Booking/create");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/create/{fid}", method=RequestMethod.GET)
	public ModelAndView GenerateFacilityPage(@PathVariable Integer fid) {
		ModelAndView mav = new ModelAndView("redirect:/Booking/create");
		Map<Integer, String> facilities = new LinkedHashMap<Integer,String>();
		Facility f = fService.findFacility(fid);
		facilities.put(f.getFacilityId(),f.getFacilityname());
		Map<Integer, String> category = new LinkedHashMap<Integer,String>();
		category.put(f.getCategoryid(), f.getCategory().getCategoryname());
		mav.addObject("bookedDates", bService.findCurrentFutureBookingsByFID(fid));
		mav.addObject("fCategory", category);
		mav.addObject("fFacility",facilities);
		return mav;
		
	}
	
	
	@RequestMapping(value = "/history/cancel/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable Integer id, final RedirectAttributes redirectAttributes,
			HttpSession session) /*throws BookingNotFound*/ {

		ModelAndView mav = new ModelAndView("redirect:/Booking/history");
		Booking booking = bService.findBooking(id);
		String message = "Booking " + booking.getBookingId() + " was successfully withdrawn.";
		UserSession us = (UserSession) session.getAttribute("user");
		booking.setBookstatus(booking.CANCELLED);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	
}
