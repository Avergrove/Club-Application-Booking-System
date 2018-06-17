package sg.nus.iss.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;

import sg.nus.iss.validators.AdminBookingValidator;
import sg.nus.iss.validators.FacilityValidator;
import sg.nus.iss.exceptions.InvalidBookingDate;
import sg.nus.iss.model.Booking;
import sg.nus.iss.model.Category;
import sg.nus.iss.model.Facility;
import sg.nus.iss.model.User;
import sg.nus.iss.services.BookingService;
import sg.nus.iss.services.CategoryService;
import sg.nus.iss.services.FacilityService;

@RequestMapping(value = "/Admin/Facility")
@Controller
public class AdminFacilityController {
	
	@Autowired
	private FacilityService fser;

	@Autowired
	private CategoryService cser;
	
	@Autowired
	private BookingService bService;
	
	@Autowired
	private FacilityValidator fValidator;

	@Autowired
	private AdminBookingValidator bValidator;	

	@InitBinder("facility")
	private void initFacilityBinder(WebDataBinder binder) {
		binder.addValidators(fValidator);
	}
	
	@InitBinder("booking")
	private void initBookingBinder(WebDataBinder binder) {
		binder.addValidators(bValidator);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
	{
	 ModelAndView mav = new ModelAndView("admin-facility-list");
	 ArrayList<Facility> facl = fser.findAllFacility();	
	 mav.addObject("facilitylist",facl);	
	 return mav;
	 }
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("admin-facility-create", "facility", new Facility());
		 mav.addObject("categorylist", cser.findAllCategory());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
										  final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("admin-facilitycreate").addObject("categorylist", cser.findAllCategory());

		ModelAndView mav = new ModelAndView();
		String message = "New facility " + facility.getFacilityId() + " was successfully created.";

		fser.CreateFacility(facility);
		mav.setViewName("redirect:/Admin/Facility/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("admin-facility-edit");
		Facility f = fser.findFacilityById(id);
		mav.addObject("facility", f);
		mav.addObject("categorylist", cser.findAllCategory());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editFacilityPage(@ModelAttribute @Valid Facility facility, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes)  {
		
		
		if (result.hasErrors())
			return new ModelAndView("admin-facility-edit").addObject("categorylist", cser.findAllCategory());
		fser.changeFacility(facility);
		
		ModelAndView mav = new ModelAndView();
		String message = "New facility " + facility.getFacilityId() + " was successfully created.";
		fser.changeFacility(facility);
		mav.setViewName("redirect:/Admin/Facility/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;

		
	}
	
	//Maintenance booking page
	@RequestMapping(value = "/book-maintenance-date", method = RequestMethod.GET)
	public ModelAndView newBookingPage() {
		ModelAndView mav = new ModelAndView("admin-facility-maintenance");
		mav.addObject("booking", new Booking());
		Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
		categories.put(0, "Select Category");
		for (Category c: cser.findAllCategory()) {
			categories.put(c.getCategoryId(),c.getCategoryname());
		}
		mav.addObject("categorylist",categories);
		return mav;
	}
	
	
	@RequestMapping(value = "/book-maintenance-date", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute @Valid Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) throws ParseException, InvalidBookingDate {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Booking unsuccessful");
			Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
			categories.put(0, "Select Category");
			for (Category c: cser.findAllCategory()) {
				categories.put(c.getCategoryId(),c.getCategoryname());
			}
			return new ModelAndView("/admin-facility-maintenance").addObject("categorylist",categories);
		}
		User u=(User) request.getSession().getAttribute("user");
		booking.setMemberId(u.getMemberid());
		booking.setBookstatus(booking.MAINTENANCE);
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
				{ t = t.getCause(); }
			
			}

		ModelAndView mav = new ModelAndView();
		String message = "New booking " + booking.getBookingId() + " was successfully created.";
		mav.setViewName(String.format("redirect:/Booking/viewHistory?memberId=%s", u.getMemberid()));
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/book-maintenance-date/loadState/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String loadState(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(fser.findFacilitiesByCategory(id));
	}
	
	@RequestMapping(value = "/book-maintenance-date?facilityId={id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView RedirectBookingPage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("admin-facility-maintenance");
		mav.addObject("booking", new Booking());
		Map<Integer, String> categories = new LinkedHashMap<Integer,String>();
		Facility f= fser.findFacility(id);
		categories.put(f.getCategoryid(),f.getCategory().getCategoryname());
		for (Category c: cser.findAllCategory()) {
			if(c.getCategoryId()!=f.getCategoryid()) {
				categories.put(c.getCategoryId(),c.getCategoryname());
			}
		}
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		facilities.add(f);
		for(Facility fac:fser.findFacilitiesByCategory(id)) {
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
	@RequestMapping(value = "/book-maintenance-date/loadDates/{id}", method = RequestMethod.GET)
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
