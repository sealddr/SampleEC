package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.payment.service.PaymentMethodService;
import com.example.form.PaySelectForm;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/store")
public class PaySelectController {

	@Autowired
	private HttpSession session;

	@Autowired
	private PaymentMethodService paymentMethodService;

	@GetMapping("/payselect")
	public String getPaySelect(Model model) {
		model.addAttribute("cart", session.getAttribute("cart"));
		model.addAttribute("paymentMethodList", paymentMethodService.getAllPaymentMethods());
		return "store/payselect";

	}

	@PostMapping("/payselect")
	public String postPaySelect(Model model, @ModelAttribute PaySelectForm form) {
		model.addAttribute("cart", session.getAttribute("cart"));
		int paymentMethodId = form.getPaymentMethodId();
		if(paymentMethodId == 0) {
			return "store/demopay";

		} else {
			throw new IllegalArgumentException("不正な支払い方法が選択されました");

		}
	}
}
