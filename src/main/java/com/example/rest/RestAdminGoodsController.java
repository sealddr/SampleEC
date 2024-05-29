package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.service.GoodsService;

@RestController
@RequestMapping("/api/admin/goods")
public class RestAdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/search/{goodsId}")
    public MGoods seachGoods(@PathVariable int goodsId) {
        return goodsService.getGoodsOne(goodsId);

    }
    
}