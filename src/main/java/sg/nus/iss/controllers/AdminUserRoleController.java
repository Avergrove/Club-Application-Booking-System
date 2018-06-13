package sg.nus.iss.controllers;

import java.util.ArrayList;

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

import sg.nus.iss.model.Userrole;
import sg.nus.iss.services.UserroleService;
import sg.nus.iss.validators.RoleIdValidator;

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
	 mav.addObject("rolelist",url);
	 return mav;
	 }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createRolePage()
	{
		
		ModelAndView mav= new ModelAndView("userRoleNewForm","userrole",new Userrole());
		return mav;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView createNewRole(@ModelAttribute @Valid Userrole user, BindingResult result, final RedirectAttributes redirectAttributes)
	{
		
		if (result.hasErrors())
			return new ModelAndView("userRoleNewForm");
		ModelAndView mav= new ModelAndView();
		urs.createUser(user);
		String message= "New user role "+ user.getRolename()+"was successfuly created.";
		redirectAttributes.addFlashAttribute("message", message);
		mav.setViewName("redirect:/Admin/Role/list");
		return mav;
	}
	
	@RequestMapping(value = "/edit/{roleId}", method = RequestMethod.GET)
	public ModelAndView editRolePage(@PathVariable int roleId)
	{
		ModelAndView mav= new ModelAndView("userRoleFormEdit");
		mav.addObject("userrole", urs.findUserRole(roleId));
		return mav;
	}
	
	@RequestMapping(value = "/edit/{roleId}", method = RequestMethod.POST)
	public ModelAndView editRole(@ModelAttribute Userrole userrole,@PathVariable int roleId,BindingResult result, final RedirectAttributes redirectAttribute)
	{
	
		if (result.hasErrors())
			return new ModelAndView("userRoleFormEdit");
		urs.updateUserRole(userrole);
		ModelAndView mav= new ModelAndView("redirect:/Admin/Role/list");
		String message = "User role" + userrole.getRolename() + " was successfully updated.";
		redirectAttribute.addFlashAttribute("message", message);
		
		return mav;
	}
	
	@RequestMapping(value="/delete/{roleId}", method=RequestMethod.GET)
	public ModelAndView deleteRole(@PathVariable int roleId, final RedirectAttributes redirectAttributes)
	{
		Userrole userrole=urs.findUserRole(roleId);
		urs.removeUserRole(userrole);
		ModelAndView mav=new ModelAndView("redirect:/Admin/Role/list");
		String message = "The user role " +userrole.getRolename() + " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
		
	}

	
	
}
