package com.Jogmedia.Jogmedia.controller;

import com.Jogmedia.Jogmedia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/category")
    public String BookList(Model model){
        model.addAttribute("category",categoryService.showAllCategory());
        return "category";
    }
}
