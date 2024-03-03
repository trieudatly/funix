package com.trieudat.springboot.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    //Create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHeloo(Model theModel) {
        theModel.addAttribute("theDate",new java.util.Date());
        return "helloworld";
    }
}
