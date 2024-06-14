package com.example.domain.goods.model;

import lombok.Data;

@Data
public class MDisplayedGoods {
    private MGoods goods;
    private boolean isInCart;
    private boolean isPurchasable;
    
}
