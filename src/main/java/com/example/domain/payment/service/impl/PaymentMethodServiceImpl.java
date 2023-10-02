package com.example.domain.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.payment.model.MPaymentMethod;
import com.example.domain.payment.service.PaymentMethodService;
import com.example.repository.PaymentMethodMapper;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

    @Autowired
    private PaymentMethodMapper mapper;

    @Override
    public List<MPaymentMethod> getAllPaymentMethods() {
        return mapper.findAllPaymentMethods();
    }
    
}
