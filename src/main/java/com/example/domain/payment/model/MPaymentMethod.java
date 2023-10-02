package com.example.domain.payment.model;

import lombok.Data;

@Data
public class MPaymentMethod {
    private int paymentMethodId;
    private String paymentMethodName;
    private String destinationPage;
}
