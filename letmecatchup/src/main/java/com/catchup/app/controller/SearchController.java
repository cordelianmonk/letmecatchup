package com.catchup.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
	
	@RequestMapping(value = "searchmedia.html")
	public String searchHome() {
		return "search";
	}

}
