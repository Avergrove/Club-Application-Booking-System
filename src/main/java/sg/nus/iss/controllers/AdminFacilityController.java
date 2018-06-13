package sg.nus.iss.controllers;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.nus.iss.validators.FacilityValidator;
import sg.nus.iss.model.Facility;
import sg.nus.iss.services.CategoryService;
import sg.nus.iss.services.CategoryServiceImpl;
import sg.nus.iss.services.FacilityService;
import sg.nus.iss.services.FacilityServiceImpl;

@RequestMapping(value = "/Admin/Facility")
@Controller
public class AdminFacilityController {
	
	@Autowired
	private FacilityService fser;

	@Autowired
	private CategoryService cser;
	
	@Autowired
	private FacilityValidator fValidator;


	@InitBinder("facility")
	private void initFacilityBinder(WebDataBinder binder) {
		binder.addValidators(fValidator);
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
	

}
