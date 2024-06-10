package com.example.domain.purchasehistory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.goods.model.MGoods;
import com.example.domain.purchasehistory.service.PurchaseHistoryService;
import com.example.repository.PurchaseHistoryMapper;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService{

    @Autowired
    private PurchaseHistoryMapper mapper;

    @Override
    public List<MGoods> getPurchasedGoodsListByUserId(int userId) {
        return mapper.findPurchasedGoodsListByUserId(userId);
    }

    
}
