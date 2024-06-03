package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/store/confirm")
public class DemoPayConfirmController {
	
    @Autowired
	private HttpSession session;
    
   	@GetMapping("/demopay")
	public String getPaySelect(Model model) {
		model.addAttribute("cart", session.getAttribute("cart"));
		return "store/confirm/demopay";
	}

    @PostMapping("/demopay")
    public String postPaySelect(Model model) {
        //カートの中身を削除する
		model.addAttribute("cart", session.getAttribute("cart"));
        session.removeAttribute("cart");
        return "store/result/demopay";
    }
}
