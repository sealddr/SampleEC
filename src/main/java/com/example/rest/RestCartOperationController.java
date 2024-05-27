package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.service.CartService;
import com.example.domain.goods.service.GoodsService;
import com.example.form.AddToCartForm;
import com.example.form.RemoveFromCartForm;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/cart")
@Slf4j
public class RestCartOperationController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CartService cartService;
	
	@Autowired 
	GoodsService goodsService;
	
	@PostMapping("/add")
	public int postAddToCart(AddToCartForm form) {
		log.debug(form.toString());
		MCart cart = (MCart) session.getAttribute("cart");
		String goodsId = form.getGoodsId();
		if(cartService.hasAlreadyAdded(cart, goodsId)) return 1;
				
		MGoods goods = goodsService.getGoodsOne(goodsId);
		cartService.add(goods, cart);
		return 0;
	}
	
	@DeleteMapping("/remove")
	public int postRemoveFromCart(RemoveFromCartForm form) {
		MCart cart = (MCart) session.getAttribute("cart");
		String goodsId = form.getGoodsId();
					
		cartService.remove(goodsId, cart);
		return 0;
	}

}
