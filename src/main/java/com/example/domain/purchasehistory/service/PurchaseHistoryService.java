package com.example.domain.purchasehistory.service;

import java.util.List;

import com.example.domain.goods.model.MGoods;

public interface PurchaseHistoryService {

    public List<MGoods> getPurchasedGoodsListByUserId(int userId);

}