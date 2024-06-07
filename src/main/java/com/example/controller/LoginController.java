package com.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;
import com.example.domain.login.model.LoginTransitionSource;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		session.setAttribute("loginTransitionSource", LoginTransitionSource.GET_LOGIN);
		return "login";
	}
	
	@GetMapping("/login/success")
	public String getLoginSuccess(Model model, Principal principal) {

		LoginTransitionSource loginTransitionSource = (LoginTransitionSource) session.getAttribute("loginTransitionSource");	
		session.setAttribute("loginTransitionSource", LoginTransitionSource.INVALID);

    	// ユーザーのロールを取得
    	Collection<? extends GrantedAuthority> authorities = ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getAuthorities();

    	// ロールが"ROLE_ADMIN"の場合
    	if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
        	return "redirect:/admin";
    	}

		// ロールが"ROLE_USER"の場合
		if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {

			// カートに遷移する場合
			if(loginTransitionSource.equals(LoginTransitionSource.POST_STORE_CART_VIEW)){
				MCart cart = (MCart) session.getAttribute("cart");
				if(null == cart) {
					cart = new MCart();
					cart.setCartItems(new ArrayList<MGoods>());
					cart.setSumPrice(0);
				}
				model.addAttribute("cart", cart);
				return "redirect:/store/cart";
			}
			// ユーザー画面に遷移する場合
			return "redirect:/user";
		}

		// デフォルトのユーザー画面に遷移する場合
		return "redirect:/user";

	}
}
