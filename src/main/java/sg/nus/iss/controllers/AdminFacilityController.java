package sg.nus.iss.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.iss.model.Facility;
import sg.nus.iss.services.FacilityServiceImpl;

@RequestMapping(value = "/Admin/Facility")
@Controller
public class AdminFacilityController {
	
	@Autowired
	private FacilityServiceImpl fser;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
	{
	 ModelAndView mav = new ModelAndView("facility-list");
	 ArrayList<Facility> facl = fser.findAllFacility();
	 for (Facility s: facl)
	 {
		 	System.out.println(s.toString());
	 }
	 mav.addObject("facilitylist",facl);
	 return mav;
	 }
	

}
