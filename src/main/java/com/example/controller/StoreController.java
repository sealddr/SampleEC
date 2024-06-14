package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.goods.model.MDisplayedGoods;
import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.model.MGoodsCategory;
import com.example.domain.goods.model.MGoodsSearchKeys;
import com.example.domain.goods.service.GoodsService;
import com.example.domain.user.model.MUser;
import com.example.form.SearchGoodsForm;

import com.example.domain.cart.model.MCart;
import com.example.domain.cart.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StoreController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/store")
	public String getStore(@ModelAttribute SearchGoodsForm form, Model model) {
		initializeSession();
		
		List<MGoodsCategory> goodsCategoryList = goodsService.getGoodsCategories();		
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		MGoodsSearchKeys searchKeys = modelMapper.map(form, MGoodsSearchKeys.class);		
		List<MDisplayedGoods> displayedGoodsList = this.searchDisplayedGoods(searchKeys);
		model.addAttribute("displayedGoodsList", displayedGoodsList);		

		return "store";
		
	}
	
	@PostMapping("/store")
	public String postStore(@ModelAttribute SearchGoodsForm form, Model model) {
		List<MGoodsCategory> goodsCategoryList = goodsService.getGoodsCategories();		
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		MGoodsSearchKeys searchKeys = modelMapper.map(form, MGoodsSearchKeys.class);
		
		List<MDisplayedGoods> displayedGoodsList = this.searchDisplayedGoods(searchKeys);
		model.addAttribute("displayedGoodsList", displayedGoodsList);
		return "store";
		
	}

	private List<MDisplayedGoods> searchDisplayedGoods(MGoodsSearchKeys searchKeys) {
		List<MGoods> goodsList = goodsService.getGoods(searchKeys);
		List<MDisplayedGoods> displayedGoodsList = new ArrayList<MDisplayedGoods>();
		for (MGoods goods : goodsList) {
			MDisplayedGoods displayedGoods = new MDisplayedGoods();
			displayedGoods.setGoods(goods);
			displayedGoods.setInCart(false);
			displayedGoods.setPurchasable(true);
			displayedGoodsList.add(displayedGoods);

		}
		try{
			// ユーザーがログイン状態の場合、カートに商品が存在するか、購入履歴に商品が存在するかを確認
			MUser user = (MUser) session.getAttribute("loginUser");
			int userId = user.getUserId();
			MCart cart = (MCart) session.getAttribute("cart");

			for (MDisplayedGoods displayedGoods : displayedGoodsList) {
				int goodsId = displayedGoods.getGoods().getGoodsId();

				// カートに商品が存在すればカートに追加不可
				if (cartService.isInCart(cart, goodsId)) {
					displayedGoods.setInCart(true);

				}

				// 購入履歴に商品が存在すれば購入不可
				if (goodsService.isInPurchaseHistory(userId, goodsId)) {
					displayedGoods.setPurchasable(false);

				}

			}

		}catch(NullPointerException e){
			// NOP

		}

		return displayedGoodsList;
	}

	private void initializeSession() {
		if(null == session.getAttribute("cart")) {
			MCart cart = new MCart();
			cart.setCartItems(new ArrayList<MGoods>());
			cart.setSumPrice(0);
			session.setAttribute("cart", cart);
		}
		MCart cart = (MCart)session.getAttribute("cart");
		if(null == cart.getCartItems()) {
			cart.setCartItems(new ArrayList<MGoods>());
			cart.setSumPrice(0);
		}
		
	}

}
