package com.quispesucso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home_GET() 
	{
		return "home";
	}
}
