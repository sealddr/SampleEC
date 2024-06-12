package com.example.controller;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowGoodsController {

    @GetMapping("/goods/{serviceURL}")
    public String showGoods(@PathVariable String serviceURL){
        return "goods/" + serviceURL;
    }    

}
