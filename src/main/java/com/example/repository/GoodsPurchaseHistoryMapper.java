package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.goods.model.MGoods;

@Mapper
public interface GoodsPurchaseHistoryMapper {
    public List<MGoods> findPurchasedGoodsListByUserId(int userId);

    public void insertGoodsPurchaseHistory(int userId, int goodsId, int paymentMethodId);

}