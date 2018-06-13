package sg.nus.iss.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	// Loads the home page and session, if id is provided in cookies.
	@RequestMapping(value="/")
	public ModelAndView home() {
		
		return new ModelAndView("home");
	}
}
