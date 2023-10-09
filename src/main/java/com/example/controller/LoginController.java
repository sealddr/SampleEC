package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getBuyLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postBuyLogin() {
		return "redirect:/cart/view";
	}
}
