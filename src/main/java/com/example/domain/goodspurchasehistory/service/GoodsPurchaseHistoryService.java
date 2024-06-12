package com.example.domain.goodspurchasehistory.service;

import java.util.List;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goodspurchasehistory.model.MOwnedGoods;

public interface GoodsPurchaseHistoryService {

    public List<MOwnedGoods> getPurchasedGoodsListByUserId(int userId);

    public void registerGoodsPurchaseHistory(int userId, List<MGoods> items, int paymentMethodId);

}