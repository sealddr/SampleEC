package com.example.domain.goods.model;

import lombok.Data;

@Data
public class MGoods {
	private String goodsId;
	private String goodsName;
	private String goodsDescription;
	private int goodsCategoryId;
	private int price;
	private MGoodsCategory goodsCategory;
	
}
