package com.example.domain.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.payment.model.MPaymentMethod;

@Service
public interface PaymentMethodService {
    public List<MPaymentMethod> getAllPaymentMethods();
}
