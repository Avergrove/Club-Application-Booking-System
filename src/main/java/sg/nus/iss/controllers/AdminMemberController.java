package sg.nus.iss.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sg.nus.iss.model.User;
import sg.nus.iss.services.UserService;

@RequestMapping(value = "/User")
@Controller
public class AdminMemberController {

	@Autowired
	private UserService us;

//	@RequestMapping(value = "/create", method = RequestMethod.GET)
//	public ModelAndView newUserPage() {
//		ModelAndView mav = new ModelAndView("user-new", "user", new User());
//		ArrayList<User> eidList = us.findAllUsers();
//		mav.addObject("eidlist", eidList);
//		return mav;
//	}
//
//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
//			final RedirectAttributes redirectAttributes) {
//
//		if (result.hasErrors())
//			return new ModelAndView("user-new");
//
//		ModelAndView mav = new ModelAndView();
//		String message = "New user " + user.getMemberid() + " was successfully created.";
//
//		us.createUser(user);
//		mav.setViewName("redirect:/admin/user/list");
//
//		redirectAttributes.addFlashAttribute("message", message);
//		return mav;
//	}
		
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll()
		{
		 ModelAndView mav = new ModelAndView("user-list");
		 ArrayList<User> ul = us.findAllUsers();
		 for (User s : ul) {
				System.out.println(s.toString());
			}
		 
		 mav.addObject("userList",ul);
		 return mav;
		 
		 
		}

}
