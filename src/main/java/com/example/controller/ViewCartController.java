package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewCartController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/cart/view")
	public String getViewCart(Model model) {
		MCart cart = (MCart) session.getAttribute("cart");
		if(null == cart) {
			cart = new MCart();
			cart.setCartItems(new ArrayList<MGoods>());
			cart.setSumPrice(0);
		}
		model.addAttribute("cart", cart);
		
		return "cart/view";
	}
}
