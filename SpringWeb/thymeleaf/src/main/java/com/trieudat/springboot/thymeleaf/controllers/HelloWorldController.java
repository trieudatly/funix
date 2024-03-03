package com.trieudat.springboot.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
//need a controller method to show initial html form
@RequestMapping("/showForm")
public String showForm(){
  return "helloworld-form";
}

//need a controller method to process the html form
@RequestMapping("/processForm")
public String processForm(){
  return "helloworld";
}


//need a controller method to read form data
// add data to the model
@RequestMapping("/processFormVersionTwo")
public String letsShoutDude(HttpServletRequest request,Model model){

  //read the request parameter from the HTML form
String theName=request.getParameter("studentName");
  //convert the data to all caps
theName=theName.toUpperCase();
  //create the message
String result="yo!"+theName;
  //add message to the model
model.addAttribute("message", result);

  return "helloworld";
}

}
