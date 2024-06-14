package com.example.domain.cart.service;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;

public interface CartService {
	void add(MGoods goods, MCart cart);
	void remove(int goodsId, MCart cart);
    boolean isInCart(MCart cart, int goodsId);

}
