package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/store/demopay")
public class DemoPayConfirmController {
	
    @Autowired
	private HttpSession session;
    
   	@GetMapping("/confirm")
	public String getPaySelect(Model model) {
		model.addAttribute("cart", session.getAttribute("cart"));
		return "store/demopay/confirm";
	}

    @PostMapping("/confirm")
    public String postPaySelect(Model model) {
        //TODO 売上トランザクションデータを発行し、データベースに登録する
        
        //TODO ユーザーの所有商品データを更新する

        //カートの中身を削除する
		model.addAttribute("cart", session.getAttribute("cart"));
        session.removeAttribute("cart");
        return "store/demopay/result";
    }
}
