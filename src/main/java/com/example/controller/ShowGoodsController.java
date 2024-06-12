package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowGoodsController {

    @GetMapping("/goods/{serviceURL}")
    public String showGoods(Model model, @PathVariable String serviceURL){
        return "goods/" + serviceURL;
    }    

}
