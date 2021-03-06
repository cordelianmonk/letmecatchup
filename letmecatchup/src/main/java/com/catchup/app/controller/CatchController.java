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
import com.catchup.app.model.items.CatchSeries;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchBookService;
import com.catchup.app.model.service.interfaces.CatchMovieService;
import com.catchup.app.model.service.interfaces.CatchSeriesService;
import com.catchup.app.model.service.interfaces.CaughtBookService;
import com.catchup.app.model.service.interfaces.CaughtMovieService;
import com.catchup.app.model.service.interfaces.CaughtSeriesService;
import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class CatchController {
	private UserService userService;
	private CatchBookService catchBookService;
	private CatchMovieService catchMovieService;
	private CatchSeriesService catchSeriesService;
	private CaughtBookService caughtBookService;
	private CaughtMovieService caughtMovieService;
	private CaughtSeriesService caughtSeriesService;
	
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
    @Qualifier(value="catchMovieService")
	public void setCatchMovieService(CatchMovieService catchMovieService) {
		this.catchMovieService = catchMovieService;
	}

	@Autowired(required=true)
    @Qualifier(value="catchSeriesService")
	public void setCatchSeriesService(CatchSeriesService catchSeriesService) {
		this.catchSeriesService = catchSeriesService;
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
	
	@Autowired(required=true)
    @Qualifier(value="caughtSeriesService")
	public void setCaughtSeriesService(CaughtSeriesService caughtSeriesService) {
		this.caughtSeriesService = caughtSeriesService;
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
	
	@RequestMapping(value="catch_series.html")
	public String seriesHome(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
			
		model.addAttribute("catchSeriesList", user.getCatchSeriesList() );
		
		return "catchSeries";
	}
	
	@RequestMapping(value="updateCatchBook")
	public String updateCatchBook(
			@RequestParam("bid") int bid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			HttpSession session,
			Model model) 
	{	
		User user = (User) session.getAttribute("user");
		
		CatchBook catchBook = this.catchBookService.searchCatchBookByID(bid);
		catchBook.setTitle(title);
		catchBook.setComment(comment);
		
		this.catchBookService.updateCatchBook(catchBook);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchBookMessage", catchBook.getTitle() + " updated.");
		model.addAttribute("catchBookList", user.getCatchBookList() );
		
		return "catchBooks";
	}
	
	@RequestMapping(value="deleteCatchBook")
	public String deleteCatchBook(
			@RequestParam("bid") int bid,
			HttpSession session,
			Model model)
	{
		User user = (User) session.getAttribute("user");
		CatchBook catchBook = this.catchBookService.searchCatchBookByID(bid);
		String title = catchBook.getTitle();
		
		this.catchBookService.deleteCatchBook(bid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchBookMessage", title + " deleted.");
		model.addAttribute("catchBookList", user.getCatchBookList() );
		
		return "catchBooks";
	}
	
	@RequestMapping(value="caughtCatchBook")
	public String caughtCatchBook(
			@RequestParam("bid") int bid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("apiID") String apiID,
			@RequestParam("rating") int rating,
			HttpSession session,
			Model model
			)
	{
		User user = (User) session.getAttribute("user");
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		this.caughtBookService.newCaughtBook(user, date, title, comment, apiID, rating);
		
		this.catchBookService.deleteCatchBook(bid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchBookMessage", title + " added to Caught list.");
		model.addAttribute("catchBookList", user.getCatchBookList() );
		
		return "catchBooks";
	}
	
	@RequestMapping(value="updateCatchMovie")
	public String updateCatchMovie(
			@RequestParam("mid") int mid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			HttpSession session,
			Model model) 
	{	
		User user = (User) session.getAttribute("user");
		
		CatchMovie catchMovie = this.catchMovieService.searchMovieByID(mid);
		catchMovie.setTitle(title);
		catchMovie.setComment(comment);
		
		this.catchMovieService.updateMovie(catchMovie);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchMovieMessage", title + " updated.");
		model.addAttribute("catchMovieList", user.getCatchMovieList() );
		
		return "catchMovies";
	}
	
	@RequestMapping(value="deleteCatchMovie")
	public String deleteCatchMovie(
			@RequestParam("mid") int mid,
			HttpSession session,
			Model model)
	{
		User user = (User) session.getAttribute("user");
		
		CatchMovie catchMovie = this.catchMovieService.searchMovieByID(mid);
		String title = catchMovie.getTitle();
		
		this.catchMovieService.deleteCatchMovie(mid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchMovieMessage", title + " deleted.");
		model.addAttribute("catchMovieList", user.getCatchMovieList() );
		
		return "catchMovies";
	}
	
	@RequestMapping(value="caughtCatchMovie")
	public String caughtCatchMovie(
			@RequestParam("mid") int mid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("apiID") String apiID,
			@RequestParam("rating") int rating,
			HttpSession session,
			Model model
			)
	{
		User user = (User) session.getAttribute("user");
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		this.caughtMovieService.newCaughtMovie(user, date, title, comment, apiID, rating);
		this.catchMovieService.deleteCatchMovie(mid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchMovieMessage", title + " added to Caught list.");
		model.addAttribute("catchMovieList", user.getCatchMovieList() );
		
		return "catchMovies";
	}
	
	@RequestMapping(value="updateCatchSeries")
	public String updateCatchSeries(
			@RequestParam("sid") int sid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			HttpSession session,
			Model model) 
	{	
		User user = (User) session.getAttribute("user");
		
		CatchSeries catchSeries = this.catchSeriesService.searchCatchSeriesByID(sid);
		catchSeries.setTitle(title);
		catchSeries.setComment(comment);
		
		this.catchSeriesService.updateCatchSeries(catchSeries);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchSeriesMessage", title + " updated.");
		model.addAttribute("catchSeriesList", user.getCatchSeriesList() );
		
		return "catchSeries";
	}
	
	@RequestMapping(value="deleteCatchSeries")
	public String deleteCatchSeries(
			@RequestParam("sid") int sid,
			HttpSession session,
			Model model)
	{
		User user = (User) session.getAttribute("user");
		
		CatchSeries catchSeries = this.catchSeriesService.searchCatchSeriesByID(sid);
		String title = catchSeries.getTitle();
		
		this.catchSeriesService.deleteCatchSeries(sid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchSeriesMessage", title + " deleted.");
		model.addAttribute("catchSeriesList", user.getCatchSeriesList() );
		
		return "catchSeries";
	}
	
	@RequestMapping(value="caughtCatchSeries")
	public String caughtCatchSeries(
			@RequestParam("sid") int sid,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("apiID") String apiID,
			@RequestParam("rating") int rating,
			HttpSession session,
			Model model
			)
	{
		User user = (User) session.getAttribute("user");
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		this.caughtSeriesService.newCaughtSeries(user, date, title, comment, apiID, rating);
		this.catchSeriesService.deleteCatchSeries(sid);
		
		user = (User) this.userService.getUserById( user.getUid() );
		session.setAttribute("user", user );
		
		model.addAttribute("catchSeriesMessage", title + " added to Caught list.");
		model.addAttribute("catchSeriesList", user.getCatchSeriesList() );
		
		return "catchSeries";
	}

}
