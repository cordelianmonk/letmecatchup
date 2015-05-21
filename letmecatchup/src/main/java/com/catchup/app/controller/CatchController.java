package com.catchup.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchup.app.model.book.CatchBook;
import com.catchup.app.model.service.UserService;
import com.catchup.app.model.user.User;

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
		int uid = (int)( (User) session.getAttribute("user") ).getUid();
		User user = this.userService.getUserById( uid );
				
		model.addAttribute("catchBookList", user.getCatchBookList() );
		
		return "catchBooks";
	}
	
	@RequestMapping(value="catch_movies.html")
	public String moviesHome(HttpSession session, Model model) {
		int uid = (int)( (User) session.getAttribute("user") ).getUid();
		User user = this.userService.getUserById( uid );
				
		model.addAttribute("catchMovieList", user.getCatchMovieList() );
		
		return "catchMovies";
	}

}
