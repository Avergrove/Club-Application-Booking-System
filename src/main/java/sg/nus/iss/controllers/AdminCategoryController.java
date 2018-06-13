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

import sg.nus.iss.validators.CategoryValidator;
import sg.nus.iss.model.Category;
import sg.nus.iss.services.CategoryServiceImpl;


@RequestMapping(value = "/Admin/Category")
@Controller
public class AdminCategoryController {
	
	
	
	@Autowired
	private CategoryServiceImpl cser;
	
	@Autowired
	private CategoryValidator cValidator;

	@InitBinder("category")
	private void initCategoryBinder(WebDataBinder binder) {
		binder.addValidators(cValidator);
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
	{
	 ModelAndView mav = new ModelAndView("category-list");
	 ArrayList<Category> catl = cser.findAllCategory();	
	 mav.addObject("categorylist",catl);	
	 return mav;
	 }
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("Categorycreate", "category", new Category ());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewCategory(@ModelAttribute @Valid Category category, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("Categorycreate");

		ModelAndView mav = new ModelAndView();
		String message = "New Category " + category.getCategoryId() + " was successfully created.";

	  cser.CreateCategory(category);
		mav.setViewName("redirect:/Admin/Category/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCategoryPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("Categoryedit");
		Category c = cser.findCategoryById(id);
		mav.addObject("category", c);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCategoryPage(@ModelAttribute @Valid Category category, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes)  {

		if (result.hasErrors())
			return new ModelAndView("Categoryedit");
		cser.changeCategory(category);
		
		ModelAndView mav = new ModelAndView();
		String message = "New category " + category.getCategoryId() + " was successfully created.";
		mav.setViewName("redirect:/Admin/Category/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;


		

		

		
	}
	

}

