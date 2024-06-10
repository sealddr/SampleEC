package com.example.form;

import lombok.Data;

@Data
public class PaySelectForm {
    private int paymentMethodId;
    private String paymentMethodName;
    private String destinationPage;    
    
}
