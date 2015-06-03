package com.catchup.app.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchBookService;
import com.catchup.app.model.service.interfaces.CatchMovieService;
import com.catchup.app.model.service.interfaces.CaughtBookService;
import com.catchup.app.model.service.interfaces.CaughtMovieService;
import com.catchup.app.model.service.interfaces.UserService;

@Controller
public class SearchController {
	private CatchBookService catchBookService;
	private CatchMovieService catchMovieService;
	private CaughtBookService caughtBookService;
	private CaughtMovieService caughtMovieService;
	private UserService userService;
	
	@RequestMapping(value = "searchmedia.html")
	public String searchHome() {
		return "search";
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
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/addCatchMedia", method=RequestMethod.POST)
	public String addCatchMedia(
			@RequestParam("mediatype") String mediaType,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			@RequestParam("apiID") String apiID,
			HttpSession session,
			Model model
			)
	{	
		User user = (User) session.getAttribute("user");
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		switch(mediaType){
		
		case "book":
			
			if( this.catchBookService.newCatchBook(user, date, title, comment, apiID) ){
				
				user = this.userService.getUserById( user.getUid() );
				session.setAttribute("user", user );
				
				model.addAttribute("searchMessage", "<strong>" + title + "</strong> saved to your Catch Book list.");
				
				return "search";
				
			} else {
				model.addAttribute("searchErrorMessage", "<strong>" + title + "</strong> already exists in your Catch Book list.");
				return "search";
			}
			
		case "movie":
			if(catchMovieService.newCatchMovie(user, date, title, comment, apiID) ){
				
				user = this.userService.getUserById( user.getUid() );
				session.setAttribute("user", user );
				
				model.addAttribute("searchMessage", "<strong>" + title + "</strong> saved to your Catch Movie list.");
				
				return "search";
				
			} else {
				model.addAttribute("searchErrorMessage", "<strong>" + title + "</strong> already exists in your Catch Movie list.");
				return "search";
			}
			
		}
		
		return "search";
		
	}
	
	@RequestMapping(value = "/addCaughtMedia", method=RequestMethod.POST)
	public String addCaughtMedia(
			@RequestParam("mediatype") String mediaType,
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
		
		switch(mediaType){
		case "book":
			if( this.caughtBookService.newCaughtBook(user, date, title, comment, apiID, rating) ){
				
				user = this.userService.getUserById( user.getUid() );
				session.setAttribute("user", user );
				
				model.addAttribute("searchMessage", "<strong>" + title + "</strong> saved to Caught Book list.");
				
				return "search";
				
			} else {
				
				model.addAttribute("searchErrorMessage", "<strong>" + title + "</strong> already exists in your Caught Book list.");
				return "search";
				
			}
		case "movie":
			
			if(caughtMovieService.newCaughtMovie(user, date, title, comment, apiID, rating) )
			{	
				user = this.userService.getUserById( user.getUid() );
				session.setAttribute("user", user );
				
				model.addAttribute("searchMessage", "<strong>" + title + "</strong> saved to Caught Movie list.");
				return "search";
				
			} else {
				
				model.addAttribute("searchErrorMessage", "<strong>" + title + "</strong> already exists in your Caught Movie list.");
				return "search";
				
			}
			
		}
		
		return "search";
		
	}

}
