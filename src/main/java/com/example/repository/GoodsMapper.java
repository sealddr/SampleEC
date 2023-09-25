package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.model.MGoodsCategory;
import com.example.domain.goods.model.MGoodsSearchKeys;

@Mapper
public interface GoodsMapper {

	public List<MGoodsCategory> findAllGoodsCategories();
	
	public List<MGoods> findAllGoods(MGoodsSearchKeys keys);
	
	public MGoods findOne(String goodsId);
}
