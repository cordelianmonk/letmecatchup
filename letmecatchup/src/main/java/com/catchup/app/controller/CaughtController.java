package com.catchup.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchup.app.model.items.CaughtBook;
import com.catchup.app.model.items.CaughtMovie;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CaughtBookService;
import com.catchup.app.model.service.interfaces.CaughtMovieService;
import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class CaughtController {
	private UserService userService;
	private CaughtBookService caughtBookService;
	private CaughtMovieService caughtMovieService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired(required=true)
    @Qualifier(value="caughtBookService")
	public void setCaughtBookService(CaughtBookService caughtBookService) {
		this.caughtBookService = caughtBookService;
	}
	
	@Autowired(required=true)
    @Qualifier(value="caughtMovieService")
	public void setCaughtMovieService(CaughtMovieService caughtMovieService) {
		this.caughtMovieService = caughtMovieService;
	}
	
	@RequestMapping(value="caught_books.html")
	public String booksHome(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("caughtBookList", user.getCaughtBookList() );
		
		return "caughtBooks";
	}
	
	@RequestMapping(value="caught_movies.html")
	public String moviesHome(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("caughtMovieList", user.getCaughtMovieList() );
		
		return "caughtMovies";
	}
	
	@RequestMapping(value="updateCaughtBook")
	public String updateCaughtBook(
			@RequestParam("bid") int bid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("rating") int rating,
			HttpSession session) 
	{
		CaughtBook caughtBook = this.caughtBookService.searchCaughtBookByID(bid);
		caughtBook.setTitle(title);
		caughtBook.setComment(comment);
		caughtBook.setRating(rating);
		
		this.caughtBookService.updateCaughtBook(caughtBook);
		
		User user = (User) session.getAttribute("user");
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
	
		return "redirect: caught_books.html";
	}
	
	@RequestMapping(value="deleteCaughtBook")
	public String deleteCaughtBook(
			@RequestParam("bid") int bid,
			HttpSession session)
	{
		
		this.caughtBookService.deleteCaughtBook(bid);
		
		User user = (User) session.getAttribute("user");
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
		
		return "redirect: caught_books.html";
	}
	
	@RequestMapping(value="updateCaughtMovie")
	public String updateCaughtMovie(
			@RequestParam("mid") int mid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("rating") int rating,
			HttpSession session)
	{
		CaughtMovie caughtMovie = this.caughtMovieService.searchCaughtMovieByID(mid);
		caughtMovie.setTitle(title);
		caughtMovie.setComment(comment);
		caughtMovie.setRating(rating);
		
		this.caughtMovieService.updateCaughtMovie(caughtMovie);
		
		User user = (User) session.getAttribute("user");
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
		
		return "redirect: caught_movies.html";
	}
	
	@RequestMapping(value="deleteCaughtMovie")
	public String deleteCaughtMovie(
			@RequestParam("mid") int mid,
			HttpSession session)
	{
		
		this.caughtMovieService.deleteCaughtMovie(mid);
		
		User user = (User) session.getAttribute("user");
		user = this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user);
		
		return "redirect: caught_movies.html";
	}
	

}
