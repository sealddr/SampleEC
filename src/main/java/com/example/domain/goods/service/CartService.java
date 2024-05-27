package com.example.domain.goods.service;

import com.example.domain.cart.model.MCart;
import com.example.domain.goods.model.MGoods;

public interface CartService {

	boolean hasAlreadyAdded(MCart cart, int goodsId);

	void add(MGoods goods, MCart cart);

	void remove(int goodsId, MCart cart);

}
