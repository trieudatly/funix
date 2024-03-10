package com.trieudat.springboot.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    //need a controller method to show the initial html form
    @RequestMapping("/showform")
    public String showForm() {
        return "helloworld-form";
    }
    //need a controller method to process the html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
}
