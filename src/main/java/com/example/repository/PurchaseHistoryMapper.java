package com.example.repository;

import java.util.List;

import com.example.domain.goods.model.MGoods;

public interface PurchaseHistoryMapper {
    public List<MGoods> findPurchasedGoodsListByUserId(int userId);

}