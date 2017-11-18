package com.blibli.services;

import com.blibli.dao_api.BookDaoInterface;
import com.blibli.dao_api.CategoryDaoInterface;
import com.blibli.model.Book;
import com.blibli.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDaoInterface categoryDaoInterface;
    CategoryDaoInterface dao;

    public List<Category> showAllCategory(){
        List<Category> temp= dao.getAllCategory();
        return temp;
    }
    public void save(Category category){
        dao.insertCategory(category);
    }
    public Category getIdCategory(Integer id){
        Category get= dao.getIdCategory(id);
        return get;
    }
    public void deleteCategory(Integer id){
        dao.delete(id);
    }
    public List<Category> searchCategory(String searchKey){
        List<Category> categories= categoryDaoInterface.search(searchKey);
        return categories;
    }

}
