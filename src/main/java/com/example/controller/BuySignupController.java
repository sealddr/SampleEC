package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Occupation;
import com.example.domain.user.service.UserService;
import com.example.form.BuySignupForm;
import com.example.form.GroupOrder;

@Controller
@RequestMapping("/buy")
public class BuySignupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/signup")
	public String getBuySignup(Model model, @ModelAttribute BuySignupForm form) {
		
		List<Occupation> occupationList = userService.getOccupations();
		model.addAttribute("occupationList", occupationList);
		return "buy/signup";
	}
	
	@PostMapping("/signup")
	public String postBuySignup(Model model,
			@ModelAttribute @Validated(GroupOrder.class) BuySignupForm form, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return getBuySignup(model, form);
		}
		
		MUser user = modelMapper.map(form, MUser.class);		
		userService.buySignUp(user);
		
		return "buy/payselect";
	}
}
