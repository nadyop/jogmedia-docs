package com.blibli.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("")
    public String home(){
        return "home";
    }
    @RequestMapping("/home")
    public String homee(){
        return "home";
    }
}