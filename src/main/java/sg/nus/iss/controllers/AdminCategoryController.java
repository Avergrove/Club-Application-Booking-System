package sg.nus.iss.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.iss.model.Category;
import sg.nus.iss.services.CategoryServiceImpl;

@RequestMapping(value = "/Admin/Category")
@Controller
public class AdminCategoryController {
	
	
	@Autowired
	private CategoryServiceImpl caser;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
	{
	 ModelAndView mav = new ModelAndView("category-list");
	 ArrayList<Category> catl = caser.findAllCategory();
	 for (Category s: catl)
	 {
		 	System.out.println(s.toString());
	 }
	 mav.addObject("Categorylist",catl);
	 return mav;
	 }

}
