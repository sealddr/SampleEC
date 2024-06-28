package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.form.UpdateMailAddressForm;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserAxcountController {

    @Autowired
    private HttpSession session;
    
    @GetMapping("/account")
    public String getAccount(
        @ModelAttribute UpdateMailAddressForm updateMailAddressForm,
        Model model) {
        MUser user = (MUser) session.getAttribute("loginUser");
        model.addAttribute("user", user);
        return "user/account";
        
    }
        
}
