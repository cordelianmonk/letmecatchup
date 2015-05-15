package com.catchup.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CaughtController {
	
	@RequestMapping(value="caught_all.html")
	public String allHome() {
		return "caughtAll";
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
