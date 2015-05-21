package com.catchup.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class CatchController {
	UserService userService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="catch_books.html")
	public String booksHome(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
				
		model.addAttribute("catchBookList", user.getCatchBookList() );
		
		return "catchBooks";
	}
	
	@RequestMapping(value="catch_movies.html")
	public String moviesHome(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
				
		model.addAttribute("catchMovieList", user.getCatchMovieList() );
		
		return "catchMovies";
	}

}
