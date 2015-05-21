package com.catchup.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class CaughtController {
	UserService userService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="caught_books.html")
	public String booksHome() {
		return "caughtBooks";
	}
	
	@RequestMapping(value="caught_movies.html")
	public String moviesHome() {
		return "caughtMovies";
	}

}
