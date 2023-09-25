package com.example.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/study")
public class ButtonListResponseController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/buttonListResponse")
	public String getRestButtonListResponse(Model model) {
		String buttonValue = (String) session.getAttribute("buttonValue");
		model.addAttribute("buttonListResponse", buttonValue);
		return "study/buttonListResponse";
	}
}
