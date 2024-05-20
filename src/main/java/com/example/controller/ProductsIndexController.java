package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/products")
public class ProductsIndexController {
    
        @RequestMapping("/")
        public String index() {
            return "admin/products/index";
        }
    
}
