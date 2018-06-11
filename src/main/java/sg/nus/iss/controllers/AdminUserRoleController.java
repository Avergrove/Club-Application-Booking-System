package sg.nus.iss.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.iss.model.Userrole;
import sg.nus.iss.services.UserroleService;

@RequestMapping(value = "/Admin/Role")
@Controller
public class AdminUserRoleController {

	@Autowired
	private UserroleService urs;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
	{
	 ModelAndView mav = new ModelAndView("Userrole-list");
	 ArrayList<Userrole> url = urs.findAllRoles();
	 for (Userrole s: url)
	 {
		 	System.out.println(s.toString());
	 }
	 mav.addObject("rolelist",url);
	 return mav;
	 }
	
	
}
