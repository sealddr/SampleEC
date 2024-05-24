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

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Occupation;
import com.example.domain.user.service.UserService;
import com.example.form.SignupForm;
import com.example.form.GroupOrder;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HttpSession session;

	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		
		List<Occupation> occupationList = userService.getOccupations();
		model.addAttribute("occupationList", occupationList);
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(Model model,
			@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return getSignup(model, form);
		}
		
		MUser user = modelMapper.map(form, MUser.class);		
		userService.signUp(user);
		
		model.addAttribute("cart", session.getAttribute("cart"));		

		return "login";
	}
}
