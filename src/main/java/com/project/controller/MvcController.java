package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
}
