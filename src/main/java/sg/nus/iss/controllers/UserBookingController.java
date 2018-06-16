package sg.nus.iss.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;

import sg.nus.iss.exceptions.InvalidBookingDate;
import sg.nus.iss.model.Booking;
import sg.nus.iss.model.Category;
import sg.nus.iss.model.Facility;
import sg.nus.iss.model.User;
import sg.nus.iss.services.BookingService;
import sg.nus.iss.services.CategoryService;
import sg.nus.iss.services.FacilityService;
import sg.nus.iss.validators.UserBookingValidator;

@RequestMapping(value="/Booking")
@Controller
public class UserBookingController {
	
	@Autowired
	private BookingService bService;
	
	@Autowired
	private FacilityService fService;
	
	@Autowired
	private CategoryService cService;
	
	@Autowired
	private UserBookingValidator bValidator;
	
	@InitBinder("booking")
	private void initBookingBinder(WebDataBinder binder) {
		binder.addValidators(bValidator);
	}
	
		@RequestMapping(value = "/create", method = RequestMethod.GET)
		public ModelAndView newBookingPage() {
			ModelAndView mav = new ModelAndView("booking-new");
			mav.addObject("booking", new Booking());
			Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
			categories.put(0, "Select Category");
			for (Category c: cService.findAllCategory()) {
				categories.put(c.getCategoryId(),c.getCategoryname());
			}
			mav.addObject("categorylist",categories);
			return mav;
		}
		
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView createNewBooking(@ModelAttribute @Valid Booking booking, BindingResult result,
				final RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) throws ParseException, InvalidBookingDate {

			if (result.hasErrors()) {
				redirectAttributes.addFlashAttribute("message", "Booking unsuccessful");
				Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
				for (Category c: cService.findAllCategory()) {
					categories.put(c.getCategoryId(),c.getCategoryname());
				}
				return new ModelAndView("/booking-new").addObject("categorylist",categories);
			}
			User u=(User) request.getSession().getAttribute("user");
			booking.setMemberId(u.getMemberid());
			booking.setBookstatus(booking.CONFIRMED);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dd = df.format(Calendar.getInstance().getTime());	
			Date ddd= (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dd);
			booking.setBookingdate(ddd);
			try {
				bService.CreateBooking(booking);
			}
			catch(Exception e){
				Throwable t = e.getCause();
				while (t!=null)
					{ t = t.getCause(); 
					}
				}

			ModelAndView mav = new ModelAndView();
			String message = "New booking " + booking.getBookingId() + " was successfully created.";
			mav.setViewName(String.format("redirect:/Booking/viewHistory?memberId=%s", u.getMemberid()));
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		
		@RequestMapping(value = "/create", params="facilityId", method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView RedirectBookingPage(@RequestParam String facilityId) {
			ModelAndView mav = new ModelAndView("booking-new");
			Integer id=Integer.parseInt(facilityId);
			mav.addObject("booking", new Booking());
			Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
			Facility f= fService.findFacility(id);
			categories.put(f.getCategoryid(),f.getCategory().getCategoryname());
			for (Category c: cService.findAllCategory()) {
				if(c.getCategoryId()!=f.getCategoryid()) {
					categories.put(c.getCategoryId(),c.getCategoryname());
				}
			}
			ArrayList<Facility> facilities = new ArrayList<Facility>();
			facilities.add(f);
			for(Facility fac:fService.findActiveFacilitiesByCategoryId(id)) {
				if(fac.getFacilityId()!=f.getFacilityId()) {
					facilities.add(fac);
				}
			}
			ArrayList<Date> dates=new ArrayList<Date>();
			for(Booking b:bService.findBookedDatesByStatusNotEqual("CANCELLED", id)) {
				dates.add(b.getStartdate());
			}
			mav.addObject("dates",dates);
			mav.addObject("categorylist",categories);
			mav.addObject("facilitylist",facilities);
			return mav;
		}
		
		
		@RequestMapping(value = "/create/loadState/{id}", method = RequestMethod.GET)
		@ResponseBody
		public String loadState(@PathVariable("id") int id) {
			Gson gson = new Gson();
			return gson.toJson(fService.findActiveFacilitiesByCategoryId(id));
		}
		
		@RequestMapping(value = "/create/loadDates/{id}", method = RequestMethod.GET)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		@ResponseBody
		public String loadBookedDates(@PathVariable("id") int id) {
			Gson gson = new Gson();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			ArrayList<String> dates=new ArrayList<String>();
			for(Booking b:bService.findBookedDatesByStatusNotEqual("CANCELLED", id)) {
				dates.add(df.format(b.getStartdate()));
			}
			return gson.toJson(dates);
		}
			
	
}
