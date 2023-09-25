package com.example.study.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study.model.Button;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/study")
@Slf4j
public class RestButtonListController {
	
	@Autowired
	HttpSession session;
		
	@PostMapping("/setValueToSession")
	public int setValueToSession(@RequestBody Button button) {
		log.debug(button.getValue());
		session.setAttribute("buttonValue", button.getValue());
		return 0;
	}
}
