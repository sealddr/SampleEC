package com.example.domain.goodspurchasehistory.model;

import lombok.Data;

@Data
public class TGoodsPurchaseHistory {
    private int purchaseHistoryId;
    private int userId;
    private int goodsId;
    private String purchaseDate;
    private int paymentMethodId;
}