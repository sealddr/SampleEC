package com.example.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.study.form.StudyButtonForm;

@Controller
@RequestMapping("/study")
public class StudyButtonController {
	
	@GetMapping("/button")
	public String getStudyButton(@ModelAttribute StudyButtonForm form, Model model) {
		String buttonText = "ボタンを押すとここにボタンで設定された値が表示されます";
		form.setButtonValueOutput(buttonText);
		String hiddenText = "ボタンを押すとここにhiddenで設定された値が表示されます";
		form.setHiddenValueOutput(hiddenText);
		return "study/button";
	}
	
	@PostMapping(value="/button", params="buttonValue")
	public String postStudyButton(@ModelAttribute StudyButtonForm form) {
		String buttonValue = form.getButtonValue();
		form.setButtonValueOutput(buttonValue);
		return "study/button";
	}

	@PostMapping(value="/button", params="showHiddenValue")
	public String postStudyButtonHidden(@ModelAttribute StudyButtonForm form) {
		String hiddenvalue = form.getHiddenValue();
		form.setHiddenValueOutput(hiddenvalue);
		return "study/button";
	}
	

}
