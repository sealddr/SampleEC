package com.example.domain.purchasehistory.model;

import lombok.Data;

@Data
public class MPurchaseHistory {
    private int purchaseHistoryId;
    private int userId;
    private int goodsId;
    private String purchaseDate;
    private int paymentMethodId;
}