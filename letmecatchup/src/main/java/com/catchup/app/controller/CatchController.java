package com.catchup.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatchController {
	
	@RequestMapping(value="catch_all.html")
	public String allHome() {
		return "catchAll";
	}
	
	@RequestMapping(value="catch_books.html")
	public String booksHome() {
		return "catchBooks";
	}
	
	@RequestMapping(value="catch_movies.html")
	public String moviesHome() {
		return "catchMovies";
	}

}
