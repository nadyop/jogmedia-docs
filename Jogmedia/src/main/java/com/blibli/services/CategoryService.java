package com.blibli.services;

import com.blibli.dao_api.CategoryDaoInterface;
import com.blibli.model.Book;
import com.blibli.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    CategoryDaoInterface categoryDaoInterface;
    public String save(Model model, Category category){
        if (getCategoryByName(category.getCategory_name()).getCategory_id() != 0)   {
            Map<String, String > map = new HashMap<>();
            map.put("name", "Category name already exist !");
            model.addAttribute("error", map);
            model.addAttribute("category", category);
            return "manager/edit/createCategory";
        }
        categoryDaoInterface.insertCategory(category);
        return "redirect:/category";
    }

    private Category getCategoryByName(String category_name) {
        return categoryDaoInterface.getCategoryByName(category_name);
    }

    public void softDeleteCategoty(Integer id){
        categoryDaoInterface.softDeleteCategory(id);
    }

    public void deleteCategory(Integer id){
        categoryDaoInterface.delete(id);
    }

    public Model showAllCategories(Model model){
        model.addAttribute("category",categoryDaoInterface.getAllCategory());
        return model;
    }
    public Model manageFormCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return model;
    }
    public Model getIdCategory(Model model, int id){
        model.addAttribute("category",categoryDaoInterface.getIdCategory(id));
        return model;
    }
    public Model searchCategoryByTitle(Model model, String searchKey){
        model.addAttribute("category", categoryDaoInterface.search(searchKey));
        return model;
    }
}
