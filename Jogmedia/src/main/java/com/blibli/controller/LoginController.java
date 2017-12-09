package com.blibli.controller;

import com.blibli.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    @GetMapping("/hom")
    public String hom() {
        return "/hom";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
