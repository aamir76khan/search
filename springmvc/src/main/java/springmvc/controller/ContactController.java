package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	@Autowired
    private UserService userService;
	@RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
	
        System.out.println(user);
        this.userService.createUser(user);
		return "success";
	}

	/*
	 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
	 * String handleForm(@RequestParam("email") String
	 * userEmail, @RequestParam("name") String userName,
	 * 
	 * @RequestParam("password") String userPassword, Model model) {
	 * 
	 * System.out.println("user email "+userEmail);
	 * System.out.println("user name "+userName);
	 * System.out.println("user password "+userPassword );
	 * 
	 * 
	 * User user=new User(); user.setEmail(userEmail); user.setName(userName);
	 * user.setPassword(userPassword); System.out.println(user);
	 * 
	 * 
	 * model.addAttribute("email", userEmail); model.addAttribute("name", userName);
	 * model.addAttribute("password", userPassword);
	 * 
	 * model.addAttribute("user", user);
	 * 
	 * return "success"; }
	 */

}
