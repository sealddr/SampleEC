package com.example.domain.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.model.MGoodsCategory;
import com.example.domain.goods.model.MGoodsSearchKeys;
import com.example.domain.goods.service.GoodsService;
import com.example.repository.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper mapper;
		
	@Override
	public List<MGoodsCategory> getGoodsCategories() {
		return mapper.findAllGoodsCategories();
	}

	@Override
	public List<MGoods> getGoods(MGoodsSearchKeys searchKeys) {
		return mapper.findAllGoods(searchKeys);
	}

	@Override
	public MGoods getGoodsOne(int goodsId) {
		return mapper.findOne(goodsId);
	}

	@Override
	public void registerGoods(MGoods goods) {
		mapper.insertOne(goods);
	}
}
