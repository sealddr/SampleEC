package com.example.domain.goodspurchasehistory.model;

import java.util.Date;

import com.example.domain.goods.model.MGoodsCategory;

import lombok.Data;

@Data
public class MOwnedGoods {
    private int goodsPurchaseHistoryId;
    private int userId;
    private int goodsId;
    private String goodsName;
	private String goodsDescription;
    private int price;
	private String serviceURL;
    private Date purchaseDate;
	private MGoodsCategory goodsCategory;    
    
}
