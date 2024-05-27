package com.example.domain.goods.service;

import java.util.List;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.model.MGoodsCategory;
import com.example.domain.goods.model.MGoodsSearchKeys;

public interface GoodsService {
	
	public List<MGoodsCategory> getGoodsCategories();
	
	public List<MGoods> getGoods(MGoodsSearchKeys searchKeys);
	
	public MGoods getGoodsOne(int goodsId);

	public void registerGoods(MGoods goods);
}
