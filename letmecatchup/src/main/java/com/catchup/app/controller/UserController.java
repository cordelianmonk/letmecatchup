package com.catchup.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchup.app.model.service.UserService;
import com.catchup.app.model.user.User;

@Controller
public class UserController {
	private UserService userService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/checkUser", method=RequestMethod.POST)
	public String checkUser( @RequestParam("email") String email,
										@RequestParam("password") String password )
	{
		
		User user = this.userService.validateUser(email, password);
		
		if(user != null){
			System.out.println( user.getFirstName()  );
		}
			return "redirect:/index.html";
	}

	
	
	
}
