package com.catchup.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.CaughtBook;
import com.catchup.app.model.items.CaughtMovie;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchBookService;
import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class DashboardController {
	UserService userService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="dash.html")
	public String allHome(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("catchBookList", user.getCatchBookList() );
		model.addAttribute("catchMovieList", user.getCatchMovieList() );
		model.addAttribute("caughtBookList", user.getCaughtBookList() );
		model.addAttribute("caughtMovieList", user.getCaughtMovieList() );
		
		model.addAttribute( "userName", user.getFirstName() );
		
	
		
		return "dashboard";
	}
	
}
