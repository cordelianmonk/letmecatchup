package com.catchup.app.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchBookService;
import com.catchup.app.model.service.interfaces.CatchMovieService;
import com.catchup.app.model.service.interfaces.CaughtBookService;
import com.catchup.app.model.service.interfaces.CaughtMovieService;
import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class CatchController {
	private UserService userService;
	private CatchBookService catchBookService;
	private CaughtBookService caughtBookService;
	private CaughtMovieService caughtMovieService;
	private CatchMovieService catchMovieService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired(required=true)
    @Qualifier(value="catchBookService")
	public void setCatchBookService(CatchBookService catchBookService) {
		this.catchBookService = catchBookService;
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
	
	@RequestMapping(value="updateCatchBook")
	public String updateCatchBook(
			@RequestParam("bid") int bid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			HttpSession session) 
	{	
		User user = (User) session.getAttribute("user");
		
		CatchBook catchBook = this.catchBookService.searchBookByID(bid);
		catchBook.setTitle(title);
		catchBook.setComment(comment);
		
		this.catchBookService.updateBook(catchBook);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		return "redirect:catch_books.html";
	}
	
	@RequestMapping(value="deleteCatchBook")
	public String deleteCatchBook(
			@RequestParam("bid") int bid,
			HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		
		this.catchBookService.deleteCatchBook(bid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		return "redirect:catch_books.html";
	}
	
	@RequestMapping(value="caughtCatchBook")
	public String caughtCatchBook(
			@RequestParam("bid") int bid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("apiID") String apiID,
			@RequestParam("rating") int rating,
			HttpSession session
			)
	{
		User user = (User) session.getAttribute("user");
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		this.caughtBookService.newCaughtBook(user, date, title, comment, apiID, rating);
		this.catchBookService.deleteCatchBook(bid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		return "redirect:caught_books.html";
	}
	
	@RequestMapping(value="updateCatchMovie")
	public String updateCatchMovie(
			@RequestParam("mid") int mid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			HttpSession session) 
	{	
		User user = (User) session.getAttribute("user");
		
		CatchMovie catchMovie = this.catchMovieService.searchMovieByID(mid);
		catchMovie.setTitle(title);
		catchMovie.setComment(comment);
		
		this.catchMovieService.updateMoviek(catchMovie);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		return "redirect:catch_movies.html";
	}
	
	@RequestMapping(value="deleteCatchMovie")
	public String deleteCatchMovie(
			@RequestParam("mid") int mid,
			HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		
		this.catchMovieService.deleteCatchMovie(mid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		return "redirect:catch_movies.html";
	}
	
	@RequestMapping(value="caughtCatchBook")
	public String caughtCatchBook(
			@RequestParam("bid") int bid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("apiID") String apiID,
			@RequestParam("rating") int rating,
			HttpSession session
			)
	{
		User user = (User) session.getAttribute("user");
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		this.caughtBookService.newCaughtBook(user, date, title, comment, apiID, rating);
		this.catchBookService.deleteCatchBook(bid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		return "redirect:caught_books.html";
	}
	

}
