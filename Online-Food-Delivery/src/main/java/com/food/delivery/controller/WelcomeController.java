package com.food.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-Online-Food-Delivery");
		return "welcome";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About-Online-Food-Delivery");
		return "about";
	}
	
	@GetMapping("/contact")
	public String contactUs(Model model) {
		model.addAttribute("title", "ContactUs-Online-Food-Delivery");
		return "contact";
	}
}
