package com.catchup.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.catchup.app.model.service.UserService;
import com.catchup.app.model.user.User;

@Controller
public class UserController {
	private UserService userService;
	
	@RequestMapping(value="account_settings.html")
	public String allHome() {
		return "userSettings";
	}
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/checkUser", method=RequestMethod.POST)
	public String checkUser( @RequestParam("email") String email,
										@RequestParam("password") String password,
										HttpSession session)
	{
		
		User user = this.userService.validateUser(email, password);
		
		if(user != null){
			session.setAttribute("user", user);
			
			return "redirect:/dash.html";
		}
			return "redirect:/index.html";
	}

	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String addUser( @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("email") String email,
			@RequestParam("password") String password )
	{
		
		if ( userService.newUser(firstName, lastName, email, password) ){
			return "redirect:/index.html";
		} 
		return "redirect:/new.html";
	}
	
	
}
