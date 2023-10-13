package com.example.domain.cart.model;

import java.util.List;

import com.example.domain.goods.model.MGoods;

import lombok.Data;

@Data
public class MCart {
	List<MGoods> cartItems;
	int sumPrice;
}