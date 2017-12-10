package com.blibli.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("")
    public String home(){
        return "home";
    }
//    @RequestMapping("")
//    public String hom(){
//        return "hom";
//    }

    @RequestMapping("/home")
    public String homee(){
        return "home";
    }

    @RequestMapping("/manager")
    public String manager() {
        return "/manager";
    }

    @RequestMapping("/cashier")
    public String cashier() {
        return "/cashier";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
