package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.goodspurchasehistory.model.MOwnedGoods;

@Mapper
public interface GoodsPurchaseHistoryMapper {
    public List<MOwnedGoods> findPurchasedGoodsListByUserId(int userId);

    public void insertGoodsPurchaseHistory(int userId, int goodsId, int paymentMethodId);

}