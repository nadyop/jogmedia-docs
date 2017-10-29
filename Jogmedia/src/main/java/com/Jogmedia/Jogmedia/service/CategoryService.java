package com.Jogmedia.Jogmedia.service;

import com.Jogmedia.Jogmedia.dao_api.dao_inteface;
import com.Jogmedia.Jogmedia.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    dao_inteface dao;

    public  List<Category> showAllCategory(){
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
    public void updatingCategory(Category category){
        dao.updateCategory(category);
    }
    public void deleteCategory(Integer id){
        dao.delete(id);
    }


}
