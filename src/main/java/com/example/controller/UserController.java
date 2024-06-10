package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goodspurchasehistory.service.GoodsPurchaseHistoryService;
import com.example.domain.user.model.MUser;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private GoodsPurchaseHistoryService goodsPurchaseHistoryService;

    @Autowired
    private HttpSession session;

    @GetMapping("/user")
    public String getUser(Model model) {

        // ログインユーザー情報を取得
        MUser loginUser = (MUser) session.getAttribute("loginUser");
        
        // ログインユーザーが購入した商品一覧を取得
        List<MGoods> purchasedGoodsList = goodsPurchaseHistoryService.getPurchasedGoodsListByUserId(loginUser.getUserId());

        model.addAttribute("purchasedGoodsList", purchasedGoodsList);
        return "user";
    }

    
}
