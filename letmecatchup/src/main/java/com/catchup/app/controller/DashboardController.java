package com.catchup.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping(value="dash.html")
	public String allHome() {
		return "dashboard";
	}
}
