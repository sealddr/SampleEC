package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.payment.service.PaymentMethodService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/buy")
public class PaySelectController {

	@Autowired
	private HttpSession session;

	@Autowired
	private PaymentMethodService paymentMethodService;

	@GetMapping("/payselect")
	public String getPaySelect(Model model) {
		model.addAttribute("cart", session.getAttribute("cart"));
		model.addAttribute("paymentMethodList", paymentMethodService.getAllPaymentMethods());
		return "buy/payselect";
	}
}
