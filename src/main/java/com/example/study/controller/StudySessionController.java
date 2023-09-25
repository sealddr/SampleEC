package com.example.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.study.form.StudySessionForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudySessionController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/study/session")
	public String getTest(@ModelAttribute StudySessionForm form, Model model) {
		if (null == session.getAttribute("text")) {
			String text = "Hello,World";
			session.setAttribute("text", text);
		}
		model.addAttribute("studySessionText", session.getAttribute("text"));
		return "study/session";
	}
	
	@PostMapping("/study/session")
	public String postTest(@ModelAttribute StudySessionForm form, Model model) {

		String newText = form.getTextField();
		session.setAttribute("text", newText);
		model.addAttribute("studySessionText", session.getAttribute("text"));
		
		form.setTextField("");
		return "study/session";
	}
	
}
