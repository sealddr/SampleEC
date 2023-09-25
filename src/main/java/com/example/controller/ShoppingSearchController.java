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

import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.model.MGoodsCategory;
import com.example.domain.goods.model.MGoodsSearchKeys;
import com.example.domain.goods.service.GoodsService;
import com.example.form.ShoppingSearchForm;
import com.example.domain.cart.model.MCart;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingSearchController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String shoppingSearch(@ModelAttribute ShoppingSearchForm form, Model model) {
		initializeSession();
		
		List<MGoodsCategory> goodsCategoryList = goodsService.getGoodsCategories();		
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		MGoodsSearchKeys searchKeys = modelMapper.map(form, MGoodsSearchKeys.class);
		
		List<MGoods> goodsList = goodsService.getGoods(searchKeys);
		model.addAttribute("goodsList", goodsList);
		
		return "home";
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

	@PostMapping("/")
	public String postShoppingSearch(@ModelAttribute ShoppingSearchForm form, Model model) {
		List<MGoodsCategory> goodsCategoryList = goodsService.getGoodsCategories();		
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		MGoodsSearchKeys searchKeys = modelMapper.map(form, MGoodsSearchKeys.class);
		
		List<MGoods> goodsList = goodsService.getGoods(searchKeys);
		model.addAttribute("goodsList", goodsList);
		
		return "home";
		
	}
}
