package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;
import com.example.domain.goodspurchasehistory.service.GoodsPurchaseHistoryService;
import com.example.domain.user.model.MUser;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/store")
public class DemoPayController {
	
    @Autowired
	private HttpSession session;
    
    @Autowired
    private GoodsPurchaseHistoryService goodsPurchaseHistoryService;

    @PostMapping("/demopay")
    public String postPaySelect(Model model) {

        // ログインユーザー情報を取得
        MUser user = (MUser) session.getAttribute("loginUser");
        int userId = user.getUserId();

        // 購入履歴にトランザクションを登録する
        MCart cart = (MCart) session.getAttribute("cart");
        List<MGoods> items = cart.getCartItems();

        goodsPurchaseHistoryService.registerGoodsPurchaseHistory(userId, items, 0);

        //カートの中身を削除する
		model.addAttribute("cart", session.getAttribute("cart"));
        session.removeAttribute("cart");
        return "store/demopay/completed";
        
    }
}
