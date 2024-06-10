package com.example.domain.goodspurchasehistory.service;

import java.util.List;

import com.example.domain.goods.model.MGoods;

public interface GoodsPurchaseHistoryService {

    public List<MGoods> getPurchasedGoodsListByUserId(int userId);

}