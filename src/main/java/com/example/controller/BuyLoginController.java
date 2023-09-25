package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buy")
public class BuyLoginController {
	
	@GetMapping("/login")
	public String getBuyLogin() {
		return "buy/login";
	}
	
	@PostMapping("/login")
	public String postBuyLogin() {
		return "redirect:/buy/payselect";
	}
}
