package sg.nus.iss.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.nus.iss.model.Facility;
import sg.nus.iss.services.FacilityService;

@Controller
@RequestMapping(value="/Facility")
public class UserFacilityController {
	
	@Autowired
	private FacilityService fService;
	
	// Returns the detail of a facility, and sends it to facility-detail.jsp
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView showDetail(@RequestParam("facilityId") String facilityId, Model model) {
		
		
		int fid = Integer.parseInt(facilityId);
		Facility f = fService.findFacility(fid);
		model.addAttribute(f);
		// Note: If you get a model is null error, it means no query is coming back
		// Facility must exist.
		
		return new ModelAndView("facility-detail");
	}	
	
	
	// Returns a list of facilities, displays facility-list.jsp
	@RequestMapping(value = "/list")
	public String listFacilities(Model model) {
		
		ArrayList<Facility> facilities = fService.findAllFacilities();
		model.addAttribute("facilities", facilities);
		return "facility-list";
	}
	
	// Returns a list of facilities by name, displays facility-list.jsp
	@RequestMapping(value = "/list", params = "searchParam")
	public String listFacilities(@RequestParam String searchParam, Model model) {
		
		ArrayList<Facility> facilities = fService.findFacilitiesByFacilityName(searchParam);
		model.addAttribute("facilities", facilities);
		return "facility-list";
	}	
}

