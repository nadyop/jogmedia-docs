package com.blibli.controller;

import com.blibli.model.Category;
import com.blibli.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String categoryList(Model model){
        model.addAttribute("category",categoryService.showAllCategory());
        return "category";
    }

    @RequestMapping(value="/category/",method = RequestMethod.POST)
    public String simpanDataCategory(Model model, Category c){
        categoryService.save(c);
        System.out.println("BUKAN!Masuk sini!!!!!!");
        return "redirect:/category";
    }
    @RequestMapping(value = "/category/createCategory", method = RequestMethod.GET)
    public String tampilFormCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @RequestMapping(value = "/category/editCategory/{id}",method = RequestMethod.GET)
    public String editDataCategory(@PathVariable Integer id, Model model){
        model.addAttribute("category",categoryService.getIdCategory(id));
        return "createCategory";
    }

    @RequestMapping(value = "/category/hapus/{id}",method = RequestMethod.GET)
    public String hapusDataCategory(@PathVariable Integer id,Model model){
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }
}