package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;
import com.example.domain.login.model.LoginTransitionSource;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/store/cart/view")
public class ViewCartController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping
	public String getViewCart(Model model) {
		MCart cart = (MCart) session.getAttribute("cart");
		if(null == cart) {
			cart = new MCart();
			cart.setCartItems(new ArrayList<MGoods>());
			cart.setSumPrice(0);
		}
		model.addAttribute("cart", cart);
		
		return "store/cart/view";
	}
	
	@PostMapping("/loginInstraction")
	public String postLoginInstraction() {
		session.setAttribute("loginTransitionSource", LoginTransitionSource.POST_STORE_CART_VIEW);
		return "login";
	}
}
