package sg.nus.iss.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
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

import sg.nus.iss.model.User;
import sg.nus.iss.services.UserService;
import sg.nus.iss.services.UserroleService;
import sg.nus.iss.validators.MemberValidator;

@RequestMapping(value = "/Admin/User")
@Controller
public class AdminMemberController {

	@Autowired
	private UserService us;
	@Autowired
	private UserroleService urole;
	@Autowired
	private MemberValidator mv;
	
	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(mv);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
		{
		 ModelAndView mav = new ModelAndView("MemberList");
		 ArrayList<User> ul = us.findAllUsers();
		 for (User s : ul) {
				System.out.println(s.toString());
			}
		 mav.addObject("userList",ul);
		 return mav; 
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newMemberPage() {
		ModelAndView mav = new ModelAndView("MemberFormNew","user", new User());
		mav.addObject("rolelist",urole.findAllRoles());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("MemberFormNew").addObject("rolelist",urole.findAllRoles());
		
		ModelAndView mav = new ModelAndView();
		try
		{
			us.createUser(user);
		}
		catch (Exception e) {
			
			Throwable t = e.getCause();
			while (t!=null && !(t instanceof ConstraintViolationException))
				{ t = t.getCause(); }
			if(t instanceof ConstraintViolationException)
			{
				ModelAndView mv = new ModelAndView("MemberFormNew").addObject("rolelist",urole.findAllRoles());
				String s = "UserID already exists";
				mv.addObject("userconstraintmessage", s);
				return mv;
			}
		}
		String message = "New Member " + user.getMemberid() + " was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);
		mav.setViewName("redirect:/Admin/User/list");
		return mav;
	}
		

	@RequestMapping(value = "/edit/{memberid}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable int memberid)
	{
		ModelAndView mav = new ModelAndView("MemberFormEdit","user", us.findMember(memberid));
		mav.addObject("rolelist",urole.findAllRoles());
		return mav;
	}
	
	@RequestMapping(value = "/edit/{memberid}", method = RequestMethod.POST)
		public ModelAndView editUser(@ModelAttribute @Valid User user, @PathVariable int memberid,
				BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
		{
			System.out.println("Error here");
			return new ModelAndView("MemberFormEdit");		
		}
		us.UpdateMember(user);
		ModelAndView mav = new ModelAndView();
		String message = "Member" + user.getMemberid() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		mav.setViewName("redirect:/Admin/User/list");
		return mav;
	}
	
	@RequestMapping(value = "/delete/{memberid}", method = RequestMethod.GET)
	public ModelAndView deleteUserPage(@PathVariable int memberid)
	{
		ModelAndView mav = new ModelAndView("MemberRemove","user", us.findMember(memberid));
		mav.addObject("rolelist",urole.findAllRoles());
		return mav;
	}
	
	@RequestMapping(value = "/delete/{memberid}", method = RequestMethod.POST)
		public ModelAndView deleteUser(@ModelAttribute @Valid User user, @PathVariable int memberid,
				BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
		{
			System.out.println("Error here");
			return new ModelAndView("MemberRemove");		
		}
		us.UpdateMember(user);
		ModelAndView mav = new ModelAndView();
		String message = "Member" + user.getMemberid() + " was successfully updated";
		redirectAttributes.addFlashAttribute("message", message);
		mav.setViewName("redirect:/Admin/User/list");
		return mav;
	}

	
	
}
