package com.example.domain.goodspurchasehistory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goodspurchasehistory.service.GoodsPurchaseHistoryService;
import com.example.repository.GoodsPurchaseHistoryMapper;

@Service
public class GoodsPurchaseHistoryServiceImpl implements GoodsPurchaseHistoryService{

    @Autowired
    private GoodsPurchaseHistoryMapper mapper;

    @Override
    public List<MGoods> getPurchasedGoodsListByUserId(int userId) {
        return mapper.findPurchasedGoodsListByUserId(userId);
    }

    
}
