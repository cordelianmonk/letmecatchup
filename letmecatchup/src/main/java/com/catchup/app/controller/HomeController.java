package com.catchup.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/new.html", method = RequestMethod.GET)
	public String newUser() {
		return "newuser";
	}

}
