package sg.nus.iss.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value="/Admin")
	public String adminDashboard(Model model) {
		
		return "admin-dashboard";
	}
}
