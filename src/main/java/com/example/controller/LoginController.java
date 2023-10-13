package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.domain.cart.model.MCart;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/login/success")
	public String postLogin(Model model) {
		MCart cart = (MCart) session.getAttribute("cart");
		if(null == cart) cart = new MCart();
		model.addAttribute("cart", cart);
		return "redirect:/cart/view";
	}
}
