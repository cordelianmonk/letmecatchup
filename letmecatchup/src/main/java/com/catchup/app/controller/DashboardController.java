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
import com.catchup.app.model.book.CaughtBook;
import com.catchup.app.model.movie.CatchMovie;
import com.catchup.app.model.movie.CaughtMovie;
import com.catchup.app.model.service.MediaService;
import com.catchup.app.model.service.UserService;
import com.catchup.app.model.user.User;

@Controller
public class DashboardController {
	private MediaService mediaService;
	
	@Autowired(required=true)
    @Qualifier(value="mediaService")
	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(value="dash.html")
	public String allHome(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		System.out.println( user.getFirstName() );
		
		List<String> mediaList = new ArrayList<String>();
		
		for( CatchBook catchBook : user.getCatchBookList()  ){
			mediaList.add( catchBook.getTitle() );
		}
		
		for( CatchMovie catchMovie : user.getCatchMovieList()  ){
			mediaList.add( catchMovie.getTitle() );
		}
		
		for(  CaughtBook caughtBook : user.getCaughtBookList()  ){
				mediaList.add( caughtBook.getTitle() );
		}
			
		for( CaughtMovie caughtMovie : user.getCaughtMovieList()  ){
				mediaList.add( caughtMovie.getTitle() );
		}
		
		model.addAttribute("mediaList", mediaList);
		
		return "dashboard";
	}
	
}
