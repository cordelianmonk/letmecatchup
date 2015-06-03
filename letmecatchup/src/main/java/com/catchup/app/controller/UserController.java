package com.catchup.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.UserService;
import com.catchup.app.util.HashGeneratorUtils;

@Controller
public class UserController {
	private UserService userService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="log_out.html")
	public String allHome(HttpSession session) {
		session.invalidate();
		return "redirect:index.html";
	}
	
	@RequestMapping(value="/checkUser", method=RequestMethod.POST)
	public String checkUser( @RequestParam("email") String email,
										@RequestParam("password") String password,
										HttpSession session, Model model)
	{
		password=HashGeneratorUtils.generateSHA256(password);
		User user = this.userService.validateUser(email, password);
		
		if(user != null){
			session.setAttribute("user", user );
			
			return "redirect:/dash.html";
		}
		
		model.addAttribute("loginErrorMessage", "User not found");
			
		return "home";
	}

	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String addUser( @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("email") String email,
			@RequestParam("password") String password ,
			Model model)
	{
		if ( userService.newUser(firstName, lastName, email, password) ){
			model.addAttribute("registrationSuccessMessage", "Registration successful!");
			return "home";
		} 
		
		model.addAttribute("registrationErrorMessage","User already exists.");
		return "newuser";
	}
	
	@RequestMapping(value="user_settings.html")
	public String goToSettings(HttpSession session, Model model){
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "userSettings";
	}
	
	@RequestMapping(value="/editNames", method=RequestMethod.POST)
	public String editNames( 
			@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			HttpSession session
			)
	{
		User user = (User) session.getAttribute("user");
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		this.userService.updateUser(user);
	
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
		
		return "redirect:/user_settings.html";
	}
	
	@RequestMapping(value="/editEmail", method=RequestMethod.POST)
	public String editEmail( 
			@RequestParam("email") String email,
			HttpSession session
			)
	{
		
		if(email.length() <= 0 ){
			return "redirect:/user_settings.html";
		}
		
		User user = (User) session.getAttribute("user");
		
		user.setEmail(email);
		
		this.userService.updateUser(user);
	
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
		
		return "redirect:/user_settings.html";
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePassword( 
			@RequestParam("password") String password,
			HttpSession session
			)
	{
		
		if(password.length() <= 0 ){
			return "redirect:/user_settings.html";
		}
		
		User user = (User) session.getAttribute("user");

		password=HashGeneratorUtils.generateSHA256(password);
		user.setPassword(password);
		
		this.userService.updateUser(user);
	
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
		
		return "redirect:/user_settings.html";
	}
	
}
