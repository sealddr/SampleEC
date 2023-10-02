package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.payment.model.MPaymentMethod;

@Mapper
public interface PaymentMethodMapper {
    public List<MPaymentMethod> findAllPaymentMethods();
    
}