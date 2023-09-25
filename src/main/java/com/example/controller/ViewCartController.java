package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class ViewCartController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/cart/view")
	public String getViewCart(Model model) {
		model.addAttribute("cart", session.getAttribute("cart"));		
		
		return "cart/view";
	}
}
