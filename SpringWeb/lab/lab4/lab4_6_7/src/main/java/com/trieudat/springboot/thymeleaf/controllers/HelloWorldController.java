package com.trieudat.springboot.thymeleaf.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //need a controller method to read form data and
    //add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model){
        //read the request parameter from the HTML form
        String theName=request.getParameter("studentName");

        //convert the data to all caps
        theName=theName.toUpperCase();

        //create the message
        String result="Hey!"+theName;

        //add message to the model
        model.addAttribute("message",result);


        return "helloworld";
    }
}
