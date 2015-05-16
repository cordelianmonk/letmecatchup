package com.catchup.app.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchup.app.model.book.CatchBook;
import com.catchup.app.model.service.CatchBookService;
import com.catchup.app.model.service.UserService;
import com.catchup.app.model.user.User;

@Controller
public class SearchController {
	private CatchBookService catchBookService;
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
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/addCatchMedia", method=RequestMethod.POST)
	public String addMedia(
			@RequestParam("mediatype") String mediaType,
			@RequestParam("title") String title,
			@RequestParam("comment") String comment,
			HttpSession session
			)
	{
		User user = this.userService.getUserById( (int) session.getAttribute("uid") );
		java.sql.Date date = Date.valueOf( LocalDate.now() );
		
		switch(mediaType){
		case "book":
		
			if( catchBookService.newCatchBook(user, date, title, comment) ){
				System.out.println("Saved new to-read!");
				return "search";
			}
			
		}
		
		System.out.println(mediaType);
		System.out.println(title);
		System.out.println(comment);
		return "search";
	}

}
