package com.example.domain.goods.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Override
	public boolean hasAlreadyAdded(MCart cart, int goodsId) {
		List<MGoods> cartItems = cart.getCartItems();
		for (MGoods goods : cartItems) {
			if(goodsId == goods.getGoodsId()) return true;
		}
		return false;
	}

	@Override
	public void add(MGoods goods, MCart cart) {
		cart.getCartItems().add(goods);
		cart.setSumPrice(cart.getSumPrice() + goods.getPrice());
	}

	@Override
	public void remove(int goodsId, MCart cart) {
		List<MGoods> cartItems = cart.getCartItems();
		MGoods target = null;
		for (MGoods item : cartItems) {
			if(goodsId == item.getGoodsId()) {
				target = item;
				break;
			}
		}
		cartItems.remove(target);
		if(null != target){
			cart.setSumPrice(cart.getSumPrice() - target.getPrice());			
		}else{
			cart.setSumPrice(0);
		}

		
	}
}
