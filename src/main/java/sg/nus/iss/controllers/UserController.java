package sg.nus.iss.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.nus.iss.model.Booking;
import sg.nus.iss.model.User;
import sg.nus.iss.services.BookingService;
import sg.nus.iss.services.UserService;
import sg.nus.iss.services.UserroleService;
import sg.nus.iss.validators.MemberValidator;
@RequestMapping(value = "/")
@Controller
public class UserController {

	@Autowired
	private BookingService bService;
	
	@Autowired
	private UserroleService urole;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private MemberValidator mv;
	
	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(mv);
	}
	
	// Shows the registration page
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		ModelAndView mav = new ModelAndView("UserRegistration","user", new User());
		mav.addObject("rolelist",urole.findAllRoles());
		return mav;
	}
	
	// Check's user's submission, and register if valid.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView newMemberPage(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("UserRegistration").addObject("rolelist",urole.findAllRoles());
		
		ModelAndView mav = new ModelAndView();
		try
		{
			uService.createUser(user);
		}
		catch (Exception e) {
			
			Throwable t = e.getCause();
			while (t!=null && !(t instanceof ConstraintViolationException))
				{ t = t.getCause(); }
			if(t instanceof ConstraintViolationException)
			{
				ModelAndView mv = new ModelAndView("UserRegistration").addObject("rolelist",urole.findAllRoles());
				String s = "UserID already exists";
				mv.addObject("userconstraintmessage", s);
				return mv;
			}
		}
		
		String message = "New Member " + user.getMemberid() + " was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);
		mav.setViewName("redirect:/");
		return mav;		
	}
		
	// Shows the login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginForm(Model model) {
		
		return new ModelAndView("user-login");
	}	
	
	// Checks user's credentials, setup a session if login correctly, else, say invalid login.
	@RequestMapping(value = "/login-authentication", method = RequestMethod.POST)
	public ModelAndView authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password,  Model model, HttpServletRequest request) {
	
		User u = uService.authenticate(username, password);
		if(u == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			mav.addObject("valid", "Your password is invalid! orz");
			
			return mav;
		}
		
		else {
			request.getSession().setAttribute("user", u);
			return new ModelAndView("redirect:/");
		}
	}		
	
	// Invalidates (Logs out) the user
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Model model, HttpServletRequest request) {
		
		request.getSession().invalidate();
		ModelAndView mav = new ModelAndView("redirect:/");
		
		return mav;
	}
	
	
	// Lists all booking, and displays it on /Booking/viewHistory
	@RequestMapping(value = "/Booking/viewHistory", method = RequestMethod.GET)
	public ModelAndView viewHistory(@RequestParam("memberId") String memberId, Model model) {
		
		int mid = Integer.parseInt(memberId);
		ArrayList<Booking> bookings = bService.findBookingByMemberId(mid);
		model.addAttribute("bookings", bookings);
		
		return new ModelAndView("user-viewHistory");
	}
	
	
	
}
