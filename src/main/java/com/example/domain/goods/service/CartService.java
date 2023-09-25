package com.example.domain.goods.service;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;

public interface CartService {

	boolean hasAlreadyAdded(MCart cart, String goodsId);

	void add(MGoods goods,MCart cart);

	void remove(String goodsId, MCart cart);

}
